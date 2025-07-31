package com.ryukato.practice.api.gateway.util

import java.net.InetAddress
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.util.StringUtils


object WebFluxUtils {

    private const val HEADER_KEY_XFF = "X-Forwarded-For"
    private const val HEADER_KEY_REAL_IP = "X-Real-IP"
    private const val HEADER_KEY_NS_CLIENT_IP = "NS-CLIENT-IP"
    private const val COMMA = ","

    fun getInetAddress(request: ServerHttpRequest): InetAddress? {
        val realIp = request.headers[HEADER_KEY_REAL_IP]?.get(0)
        if (!realIp.isNullOrBlank()) {
            return InetAddress.getByName(realIp)
        }
        val forwardFor = request.headers[HEADER_KEY_XFF]?.get(0)
        if (!forwardFor.isNullOrBlank()) {
            val split = StringUtils.split(forwardFor, COMMA)
            return InetAddress.getByName(
                if (split.isNullOrEmpty()) forwardFor else split[0]
            )
        }
        val remoteAddress = request.headers[HEADER_KEY_NS_CLIENT_IP]?.get(0)
        return if (!remoteAddress.isNullOrBlank()) {
            InetAddress.getByName(remoteAddress)
        } else request.remoteAddress?.address ?: InetAddress.getByName(request.remoteAddress?.hostName)
    }
}
