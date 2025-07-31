package com.ryukato.practice.api.gateway.predicate

import java.nio.ByteBuffer
import java.security.MessageDigest
import java.util.function.Predicate
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange

@Component
class RouteNewApiAppPredicateFactory :
    AbstractRoutePredicateFactory<RouteNewApiAppPredicateFactory.Config>(Config::class.java) {
    data class Config(
        val header: String = "user-id",
        val rolloutPercentage: Int = 0
    )

    fun safeHashMod(value: String, mod: Int): Int {
        val digest = MessageDigest.getInstance("SHA-256").digest(value.toByteArray())
        val intHash = ByteBuffer.wrap(digest.copyOfRange(0, 4)).int
        return (intHash and 0x7FFFFFFF) % mod
    }

    override fun apply(config: Config): Predicate<ServerWebExchange> {
        return Predicate { exchange ->
            val headerValue = exchange.request.headers.getFirst(config.header) ?: return@Predicate false
            val hash = safeHashMod(headerValue, 100)
            val doRoute = hash < config.rolloutPercentage
            doRoute
        }
    }
}
