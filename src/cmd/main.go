package main

import (
	"context"
	"fmt"
	"github.com/isd-sgcu/golang-backend-template/src/config"
	"github.com/isd-sgcu/golang-backend-template/src/database"
	"net"
	"os"
	"os/signal"
	"sync"
	"syscall"
	"time"

	subscriberCommon "github.com/isd-sgcu/golang-backend-template/src/internal/subscriber/common"

	"github.com/rs/zerolog/log"
	"google.golang.org/grpc"
	"google.golang.org/grpc/health"
	"google.golang.org/grpc/health/grpc_health_v1"
	"google.golang.org/grpc/reflection"
)

type operation func(ctx context.Context) error

func gracefulShutdown(ctx context.Context, timeout time.Duration, ops map[string]operation) <-chan struct{} {
	wait := make(chan struct{})
	go func() {
		s := make(chan os.Signal, 1)

		signal.Notify(s, syscall.SIGINT, syscall.SIGTERM)
		sig := <-s

		log.Info().
			Str("service", "graceful shutdown").
			Msgf("got signal \"%v\" shutting down service", sig)

		timeoutFunc := time.AfterFunc(timeout, func() {
			log.Error().
				Str("service", "graceful shutdown").
				Msgf("timeout %v ms has been elapsed, force exit", timeout.Milliseconds())
			os.Exit(0)
		})

		defer timeoutFunc.Stop()

		var wg sync.WaitGroup

		for key, op := range ops {
			wg.Add(1)
			innerOp := op
			innerKey := key
			go func() {
				defer wg.Done()

				log.Info().
					Str("service", "graceful shutdown").
					Msgf("cleaning up: %v", innerKey)
				if err := innerOp(ctx); err != nil {
					log.Error().
						Str("service", "graceful shutdown").
						Err(err).
						Msgf("%v: clean up failed: %v", innerKey, err.Error())
					return
				}

				log.Info().
					Str("service", "graceful shutdown").
					Msgf("%v was shutdown gracefully", innerKey)
			}()
		}

		wg.Wait()
		close(wait)
	}()

	return wait
}

func main() {
	conf, err := config.LoadAppConfig()
	if err != nil {
		log.Fatal().
			Err(err).
			Str("service", "search").
			Msg("Failed to start service")
	}

	rabbitMQConn, err := database.InitRabbitMQConnection()
	if err != nil {
		log.Fatal().
			Err(err).
			Str("service", "search").
			Msg("Failed to init rabbitmq connection")
	}

	lis, err := net.Listen("tcp", fmt.Sprintf(":%v", conf.App.Port))
	if err != nil {
		log.Fatal().
			Err(err).
			Str("service", "search").
			Msg("Failed to start service")
	}
	defer lis.Close()

	subscriberManagement, err := subscriberCommon.NewSubscriberManagement()
	if err != nil {
		log.Fatal().
			Err(err).
			Str("service", "search").
			Msg("Failed to initial the subscriber management")
	}

	grpcServer := grpc.NewServer(grpc.MaxRecvMsgSize(conf.App.MaxFileSize * 1024 * 1024))

	grpc_health_v1.RegisterHealthServer(grpcServer, health.NewServer())

	reflection.Register(grpcServer)

	go func() {
		log.Info().
			Str("service", "search").
			Msg("Starting the subscriber service")

		if err := subscriberManagement.Serve(); err != nil {
			log.Fatal().
				Err(err).
				Str("service", "search").
				Msg("Failed to serve the subscribers")
		}
	}()

	go func() {
		log.Info().
			Str("service", "search").
			Msgf("Service starting at port %v", conf.App.Port)

		if err = grpcServer.Serve(lis); err != nil {
			log.Fatal().
				Err(err).
				Str("service", "search").
				Msg("Failed to start service")
		}
	}()

	wait := gracefulShutdown(context.Background(), 2*time.Second, map[string]operation{
		"server": func(ctx context.Context) error {
			grpcServer.GracefulStop()
			return nil
		},
		"rabbitmq": func(ctx context.Context) error {
			if err := subscriberManagement.GracefulShutdown(); err != nil {
				return err
			}

			return rabbitMQConn.Close()
		},
	})

	<-wait

	grpcServer.GracefulStop()

	log.Info().
		Str("service", "search").
		Msg("End of service")
}
