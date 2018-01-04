package com.tradeninja.backend.repository

import com.tradeninja.backend.model.Wallet
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface WalletRepository : ReactiveMongoRepository<Wallet, String> {

    fun getWalletByUserId(userId : String): Mono<Wallet>
}