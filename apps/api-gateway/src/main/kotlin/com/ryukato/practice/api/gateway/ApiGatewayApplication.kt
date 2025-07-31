package com.ryukato.practice.api.gateway

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

private val logger = KotlinLogging.logger {}

@SpringBootApplication(
    scanBasePackages = [
        "com.ryukato",
    ],
)
@ConfigurationPropertiesScan(
    basePackages = [
        "com.ryukato",
    ],
)
class ApiGatewayApplication

fun main(args: Array<String>) {
    val context = runApplication<ApiGatewayApplication>(*args)
    val environment = context.environment
    val newApiApp = environment.getProperty("sample.apps.host.api-app1")
    val oldApiApp = environment.getProperty("sample.apps.host.api-app2")
    logger.info {
        """
        routes destinations
         * newApiApp: $newApiApp
         * oldApiApp: $oldApiApp
        """
    }
}
