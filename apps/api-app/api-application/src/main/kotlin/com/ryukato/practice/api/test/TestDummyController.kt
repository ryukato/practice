package com.ryukato.practice.api.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/test")
class TestDummyController(
    @Value("\${test.message}") val testMessage: String,
) {

    @GetMapping("/message")
    fun getTestMessage(): Map<String, String> {
        return mapOf("message" to testMessage)
    }
}
