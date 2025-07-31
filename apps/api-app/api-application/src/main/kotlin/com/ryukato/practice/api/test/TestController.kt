package com.ryukato.practice.api.test

import com.ryukato.practice.core.domain.user.model.TestUser
import com.ryukato.practice.core.domain.user.repository.TestUserReadOnlyRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/test")
class TestController(
    @Value("\${test.message}") val testMessage: String,
    private val testUserReadOnlyRepository: TestUserReadOnlyRepository
) {

    @GetMapping("/message")
    fun getTestMessage(): Map<String, String> {
        return mapOf("message" to testMessage)
    }

    @GetMapping
    suspend fun testMessage(
        @RequestParam(name = "name", required = false) name: String? = null
    ): Map<String, String> {
        val responseName = name ?: "anonymous"
        return mapOf(
            "message" to "hello, $responseName"
        )
    }

    @GetMapping("/users/by-name")
    suspend fun queryTestUserByName(
        @RequestParam("name") name: String
    ): TestUser? {
        return testUserReadOnlyRepository.findByName(name)
    }

}
