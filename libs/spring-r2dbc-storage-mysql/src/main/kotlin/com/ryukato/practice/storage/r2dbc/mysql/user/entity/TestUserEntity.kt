package com.ryukato.practice.storage.r2dbc.mysql.user.entity

import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("test_user")
data class TestUserEntity(
    @Id @Column("row_id")
    val rowId: Long,
    @Column("user_id")
    val userId: String,
    @Column("name")
    val name: String,
    @Column("created_at")
    val createdAt: LocalDateTime
)
