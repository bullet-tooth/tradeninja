package com.tradeninja.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
        @Indexed
        val name: String,
        @Id
        val id: String? = null
)