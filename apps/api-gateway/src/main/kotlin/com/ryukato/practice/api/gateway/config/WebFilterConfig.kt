package com.ryukato.practice.api.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.handler.WebFluxResponseStatusExceptionHandler
import org.springframework.web.server.WebExceptionHandler

@Configuration
class WebFilterConfig {
    @Bean(name = ["defaultExceptionHandler"])
    fun webExceptionHandler(): WebExceptionHandler {
        return WebFluxResponseStatusExceptionHandler()
    }
}

