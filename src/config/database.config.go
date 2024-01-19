package config

import (
	"github.com/pkg/errors"
	"github.com/spf13/viper"
)

type Database struct {
	Host     string `mapstructure:"host"`
	Port     int    `mapstructure:"port"`
	User     string `mapstructure:"username"`
	Password string `mapstructure:"password"`
	Name     string `mapstructure:"name"`
	SSL      string `mapstructure:"ssl"`
}

type DatabaseConfig struct {
	Database Database `mapstructure:"database"`
}

func LoadDatabaseConfig() (config *Database, err error) {
	viper.AddConfigPath("./config")
	viper.SetConfigName("database")
	viper.SetConfigType("yaml")

	viper.AutomaticEnv()

	err = viper.ReadInConfig()
	if err != nil {
		return nil, errors.Wrap(err, "error occurs while reading the config")
	}

	conf := DatabaseConfig{}

	err = viper.Unmarshal(&conf)
	if err != nil {
		return nil, errors.Wrap(err, "error occurs while unmarshal the config")
	}

	return &conf.Database, err
}
