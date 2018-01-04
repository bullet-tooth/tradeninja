package com.tradeninja.backend.service

import com.tradeninja.backend.dto.LoginRequest
import com.tradeninja.backend.model.User
import com.tradeninja.backend.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SimpleLoginService(val userRepository: UserRepository) : LoginService {
    override fun login(request: LoginRequest): Mono<User> = userRepository.findByName(request.userName)
}