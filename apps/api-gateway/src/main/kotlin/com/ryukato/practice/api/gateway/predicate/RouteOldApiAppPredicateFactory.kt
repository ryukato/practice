package com.ryukato.practice.api.gateway.predicate

import java.util.function.Predicate
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange

@Component
class RouteOldApiAppPredicateFactory :
    AbstractRoutePredicateFactory<RouteOldApiAppPredicateFactory.Config>(Config::class.java) {
    data class Config(
        val header: String = "user-id",
        val rolloutPercentage: Int = 0
    )

    override fun apply(config: Config): Predicate<ServerWebExchange> {
        return Predicate { exchange ->
            val headerValue = exchange.request.headers.getFirst(config.header) ?: return@Predicate false
            val hash = (headerValue.hashCode() and 0x7FFFFFFF) % 100
            hash >= config.rolloutPercentage
        }
    }
}
