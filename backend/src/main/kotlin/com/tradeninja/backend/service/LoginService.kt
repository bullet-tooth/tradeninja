package com.tradeninja.backend.service

import com.tradeninja.backend.dto.LoginRequest
import com.tradeninja.backend.model.User
import reactor.core.publisher.Mono

interface LoginService {

    fun login(request: LoginRequest) : Mono<User>
}