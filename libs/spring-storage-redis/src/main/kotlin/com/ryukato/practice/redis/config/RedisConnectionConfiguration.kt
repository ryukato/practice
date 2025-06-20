package com.ryukato.practice.redis.config

import io.lettuce.core.event.DefaultEventPublisherOptions
import io.lettuce.core.metrics.CommandLatencyRecorder
import io.lettuce.core.resource.ClientResources
import io.lettuce.core.resource.Delay
import java.time.Duration
import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration

// this is not mandatory because RedisAutoConfiguration
//@Configuration
//@EnableConfigurationProperties(RedisProperties::class)
//@ComponentScan(basePackages = ["com.firstpark.redis.config"])
class RedisConnectionConfiguration {

//    @Bean
    fun clientResourceCustomize(): ClientResourcesBuilderCustomizer {
        return ClientResourcesBuilderCustomizer { builder: ClientResources.Builder ->
            builder.reconnectDelay(Delay.constant(Duration.ofSeconds(50)))
            builder.ioThreadPoolSize(4)
            builder.commandLatencyRecorder(CommandLatencyRecorder.disabled())
            builder.commandLatencyPublisherOptions(DefaultEventPublisherOptions.disabled())
        }
    }

//    @Bean
    fun lettuceClientConfigCustomize(): LettuceClientConfigurationBuilderCustomizer {
        return LettuceClientConfigurationBuilderCustomizer { builder ->
            if (builder is LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder) {
                val poolConfig = GenericObjectPoolConfig<LettuceClientConfiguration>();
                poolConfig.maxIdle = 5;
                poolConfig.minIdle = 1;
                poolConfig.maxTotal = 10
                poolConfig.setMaxWait(Duration.ofSeconds(30))
                builder.poolConfig(poolConfig)
            }
            builder.shutdownTimeout(Duration.ofSeconds(1))
        }
    }
}
