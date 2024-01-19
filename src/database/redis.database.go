package database

import (
	"github.com/go-redis/redis/v8"
	"github.com/isd-sgcu/golang-backend-template/src/config"
	"github.com/rs/zerolog/log"
)

func InitRedisConnect() (cache *redis.Client, err error) {
	conf, err := config.LoadRedisConfig()
	if err != nil {
		log.Fatal().
			Err(err).
			Str("service", "auth").
			Msg("Failed to start service")
	}

	cache = redis.NewClient(&redis.Options{
		Addr: conf.Redis.Host,
		DB:   conf.Redis.DB,
	})

	return
}
