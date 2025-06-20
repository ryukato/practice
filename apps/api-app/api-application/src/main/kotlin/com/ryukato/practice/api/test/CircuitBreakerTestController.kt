package com.ryukato.practice.api.test

import com.ryukato.practice.core.domain.common.excepion.ResourceNotFoundException
import com.ryukato.practice.core.domain.user.model.TestUser
import com.ryukato.practice.core.domain.user.repository.TestUserReadOnlyRepository
import com.ryukato.practice.core.domain.utility.CircuitBreakerState
import com.ryukato.practice.core.domain.utility.DistributedCircuitBreaker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/circuit-breaker")
class CircuitBreakerTestController(
    private val distributedCircuitBreaker: DistributedCircuitBreaker,
    private val testUserReadOnlyRepository: TestUserReadOnlyRepository
) {
    @GetMapping("/test")
    suspend fun testGet(@RequestParam("name") name: String): TestUser {
        return distributedCircuitBreaker.execute(
            key = "test"
        ) {
            testUserReadOnlyRepository.findByName(name) ?: throw ResourceNotFoundException(
                resourceType = "test-user",
                resourceIdentifier = "name:$name"
            )
        }
    }

    @GetMapping("/state")
    suspend fun getState(): Map<String, CircuitBreakerState> {
        val state = distributedCircuitBreaker.currentState("test")
        return mapOf(
            "state" to state
        )
    }

    @GetMapping("/success-counter")
    suspend fun getSuccessCounterValue(): Map<String, Long> {
        val counter = distributedCircuitBreaker.successCount("test")
        return mapOf(
            "counter" to counter
        )
    }
}
