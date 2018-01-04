package com.tradeninja.backend.service

import com.tradeninja.backend.model.Wallet
import com.tradeninja.backend.repository.UserRepository
import com.tradeninja.backend.repository.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SimpleWalletService(@Autowired
                          val walletRepository: WalletRepository
                          ) : WalletService {

    override fun getUserWallet(userId: String): Mono<Wallet> = walletRepository.getWalletByUserId(userId)

}