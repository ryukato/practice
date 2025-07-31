package com.ryukato.practice.api.gateway.util

object HashUtil {
    fun shouldRouteToNewApi(keyValue: Any, rolloutPercentage: Int): Boolean {
        val hash = (keyValue.hashCode() and 0x7FFFFFFF) % 100
        return hash < rolloutPercentage
    }

    fun shouldRouteToOldApi(keyValue: Any, rolloutPercentage: Int): Boolean {
        return !shouldRouteToNewApi(keyValue, rolloutPercentage)
    }
}
