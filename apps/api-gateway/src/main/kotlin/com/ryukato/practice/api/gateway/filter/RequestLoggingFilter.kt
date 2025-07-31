package com.ryukato.practice.api.gateway.filter

import com.ryukato.practice.api.gateway.util.WebFluxUtils
import kotlinx.coroutines.reactor.mono
import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.core.Ordered
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger {}

class RequestLoggingFilter(val config: RequestLoggingFilterFactory.RequestLoggingConfig) :
    GatewayFilter, Ordered {
    override fun getOrder() = 1

    override fun filter(
        exchange: ServerWebExchange,
        chain: GatewayFilterChain,
    ): Mono<Void> {
        return mono {
            if (config.doLogging) {
                val inetAddress = WebFluxUtils.getInetAddress(exchange.request)
                logger.info {
                    """ 
            Request \n    
             - clientIp: $inetAddress
             - requestUri: ${exchange.request.uri}
             - requestHeaders: ${exchange.request.headers}
          """.trim()
                }
            }
        }
            .flatMap { chain.filter(exchange) }
    }
}

@Component
class RequestLoggingFilterFactory :
    AbstractGatewayFilterFactory<RequestLoggingFilterFactory.RequestLoggingConfig>(
        RequestLoggingConfig::class.java,
    ) {
    override fun apply(config: RequestLoggingConfig): GatewayFilter {
        return RequestLoggingFilter(config)
    }

    class RequestLoggingConfig(
        val doLogging: Boolean,
    )
}
