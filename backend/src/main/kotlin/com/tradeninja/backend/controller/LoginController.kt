package com.tradeninja.backend.controller

import com.tradeninja.backend.controller.dto.UserDto
import com.tradeninja.backend.dto.LoginRequest
import com.tradeninja.backend.service.LoginService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class LoginController(val loginService: LoginService) {
    private val log = LoggerFactory.getLogger(javaClass)
    private val default = LoginRequest("vasia")

    @PostMapping(path = ["/v1/login"])
    fun login(@RequestBody(required = false) request: LoginRequest?): Mono<UserDto> {

        val r: LoginRequest = request ?: default

        log.info("get login request $r")

        return loginService.login(r)
                .map { (name, id) -> UserDto(id!!, name) }
    }
}

