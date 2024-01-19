package database

import (
	"github.com/isd-sgcu/golang-backend-template/src/config"
	amqp "github.com/rabbitmq/amqp091-go"
)

func InitRabbitMQConnection() (*amqp.Connection, error) {
	conf, err := config.LoadRabbitMQConfig()
	if err != nil {
		return nil, err
	}

	return amqp.DialConfig(conf.Host, amqp.Config{
		Vhost: conf.VHost,
	})
}
