package com.ryukato.practice.redis.circuit.breaker

import com.ryukato.practice.core.domain.utility.CircuitBreakerException
import com.ryukato.practice.core.domain.utility.CircuitBreakerState
import com.ryukato.practice.core.domain.utility.DistributedCircuitBreaker
import com.ryukato.practice.core.domain.utility.ExceptionClassifier
import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.redisson.api.RMapCacheReactive
import org.redisson.api.RedissonReactiveClient
import org.springframework.stereotype.Component

@Component
class RedissonCoroutineCircuitBreaker(
    private val redissonReactiveClient: RedissonReactiveClient,
) : DistributedCircuitBreaker {
    override suspend fun <T> execute(
        key: String,
        exceptionClassifier: ExceptionClassifier,
        supplier: suspend () -> T
    ): T {
        if (!isCallPermitted(key)) throw CircuitBreakerException("Circuit for [$key] is OPEN")
        return try {
            val result = supplier()
            onSuccess(key = key)
            result
        } catch (e: Exception) {
            if(!exceptionClassifier.shouldTrip(e)) {
                onFailure(key)
            }
            throw e
        }
    }

    override suspend fun isCallPermitted(key: String): Boolean {
        return currentState(key) != CircuitBreakerState.OPEN
    }

    override suspend fun currentState(key: String): CircuitBreakerState {
        val stateMap = getStateMap()
        val state = stateMap.get(key).awaitSingleOrNull()
        return state?.let {
            CircuitBreakerState.valueOf(it)
        } ?: CircuitBreakerState.HALF_OPEN
    }

    override suspend fun successCount(key: String): Long {
        return redissonReactiveClient.getAtomicLong(getSuccessCountKey(key)).get().awaitSingle()
    }

    override suspend fun failureCount(key: String): Long {
        return redissonReactiveClient.getAtomicLong(getFailureCountKey(key)).get().awaitSingle()
    }

    private suspend fun onSuccess(key: String) {
        val successCounter = redissonReactiveClient.getAtomicLong(getSuccessCountKey(key))
        val currentState = currentState(key)
        if (currentState == CircuitBreakerState.HALF_OPEN) {
            val count = successCounter.incrementAndGet().awaitSingle()
            if (count >= HALF_OPEN_SUCCESS_THRESHOLD) {
                transitionToClosed(key)
            }
        } else {
            // reset count for failure
            redissonReactiveClient.getAtomicLong(getFailureCountKey(key)).delete().awaitSingle()
        }
    }

    private suspend fun onFailure(key: String) {
        val stat = currentState(key)
        if (stat == CircuitBreakerState.OPEN) return

        val failureCounter = redissonReactiveClient.getAtomicLong(getFailureCountKey(key))
        val failureCount = failureCounter.incrementAndGet().awaitSingle()
        if (failureCount >= FAILURE_THRESHOLD) {
            transitionToOpen(key)
        }
    }

    private suspend fun transitionToOpen(key: String) {
        val stateMap = getStateMap()
        stateMap.fastPut(key, CircuitBreakerState.OPEN.name).awaitSingle()
        stateMap.expireEntry(
            key,
            Duration.of(OPEN_STATE_TTL_SEC, ChronoUnit.SECONDS), // ttl
            Duration.of(0, ChronoUnit.SECONDS) //maxIdleTime
        ).awaitSingle()

        // reset
        redissonReactiveClient.getAtomicLong(getFailureCountKey(key)).delete().awaitSingle()
        redissonReactiveClient.getAtomicLong(getSuccessCountKey(key)).delete().awaitSingle()
    }

    private suspend fun transitionToClosed(key: String) {
        val stateMap = getStateMap()
        stateMap.fastPut(key, CircuitBreakerState.CLOSED.name).awaitSingle()
        redissonReactiveClient.getAtomicLong(getFailureCountKey(key)).delete().awaitSingle()
        redissonReactiveClient.getAtomicLong(getSuccessCountKey(key)).delete().awaitSingle()
    }

    private suspend fun getStateMap(): RMapCacheReactive<String, String> {
        return redissonReactiveClient.getMapCache("cb:state")
    }

    private fun getSuccessCountKey(key: String): String {
        return "cb:$key:success"
    }

    private fun getFailureCountKey(key: String): String {
        return "cb:$key:failure"
    }

    companion object {
        const val FAILURE_THRESHOLD = 5
        const val HALF_OPEN_SUCCESS_THRESHOLD = 3
        const val OPEN_STATE_TTL_SEC = 30L
    }
}
