package com.tradeninja.backend.service

import com.tradeninja.backend.model.Wallet
import reactor.core.publisher.Mono


interface WalletService {

    fun getUserWallet(userId: String) : Mono<Wallet>
}