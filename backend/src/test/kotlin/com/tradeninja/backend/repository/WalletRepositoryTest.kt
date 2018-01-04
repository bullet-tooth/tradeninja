package com.tradeninja.backend.repository

import com.tradeninja.backend.model.User
import com.tradeninja.backend.model.Wallet
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.*
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@SpringBootTest
@RunWith(SpringRunner::class)
class WalletRepositoryTest {

    @Autowired
    lateinit var repository : WalletRepository
    @Autowired
    lateinit var operations: ReactiveMongoOperations


    @Before
    fun setUp() {
        operations.collectionExists(Wallet::class)
                .flatMap { exists -> if (exists) operations.dropCollection(Wallet::class) else  Mono.just(exists) }
                .flatMap { o -> operations.createCollection(Wallet::class) }
                .then()
                .block()
        operations.collectionExists(User::class)
                .flatMap { exists -> if (exists) operations.dropCollection(User::class) else  Mono.just(exists) }
                .flatMap { o -> operations.createCollection(User::class) }
                .then()
                .block()

//        operations.save(User("", "vasia"))

//        repository.save(Flux.just())



    }

}