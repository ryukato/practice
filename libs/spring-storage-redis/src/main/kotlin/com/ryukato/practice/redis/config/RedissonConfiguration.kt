package com.ryukato.practice.redis.config

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.api.RedissonReactiveClient
import org.redisson.codec.JsonJacksonCodec
import org.redisson.config.Config
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val PING_CONNECTION_INTERVAL_IN_MILLIS = 5000

@Configuration
@EnableConfigurationProperties(RedisProperties::class)
class RedissonConfiguration {

    @Bean
    fun redissonReactiveClient(
        redisProperties: RedisProperties,
    ): RedissonReactiveClient {
        val config = getConfig(redisProperties)
        config.nettyThreads = 4
        return Redisson.create(config).reactive()
    }

    @Bean
    fun redissonClient(
        redisProperties: RedisProperties,
    ): RedissonClient {
        val config = getConfig(redisProperties)
        config.nettyThreads = 4
        return Redisson.create(config)
    }

    private fun getConfig(redisProperties: RedisProperties): Config {
        val config = Config().setCodec(JsonJacksonCodec.INSTANCE)

        if (redisProperties.cluster == null) {
            config.useSingleServer().apply {
                address = "redis://${redisProperties.host!!}:${redisProperties.port}"
                password = redisProperties.password
                pingConnectionInterval = PING_CONNECTION_INTERVAL_IN_MILLIS
                connectionPoolSize = 10
                connectionMinimumIdleSize = 1
            }
        } else {
            config.useClusterServers().apply {
                redisProperties.cluster.nodes.forEach {
                    addNodeAddress("redis://$it")
                }
                password = redisProperties.password
                pingConnectionInterval = PING_CONNECTION_INTERVAL_IN_MILLIS
                masterConnectionPoolSize = 10
                masterConnectionMinimumIdleSize = 1
            }
        }
        return config
    }
}
