package com.tradeninja.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Wallet(
        @DBRef
        val user: User,
        val balances: List<Balance>,
        @Id
        val id: String? = null
)