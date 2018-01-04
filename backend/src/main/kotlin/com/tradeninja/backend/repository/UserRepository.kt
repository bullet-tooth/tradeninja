package com.tradeninja.backend.repository

import com.tradeninja.backend.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
interface UserRepository: ReactiveMongoRepository<User, String> {

    fun findByName(name: String) : Mono<User>

}