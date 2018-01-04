package com.tradeninja.backend.fireup

import com.tradeninja.backend.model.Balance
import com.tradeninja.backend.model.User
import com.tradeninja.backend.model.Wallet
import com.tradeninja.backend.repository.UserRepository
import com.tradeninja.backend.repository.WalletRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.math.BigDecimal
import java.util.*

@Configuration
class MongoSchemaInitializer {
    private val log = LoggerFactory.getLogger(javaClass)
    @Bean
    fun init(walletRepository: WalletRepository,
             userRepository: UserRepository) = CommandLineRunner {

        userRepository.deleteAll().block()
        walletRepository.deleteAll().block()

        val savedUser = userRepository.save(User("vasia")).block()
        log.info("saved user = $savedUser")

        val savedWallet = walletRepository.save(Wallet(savedUser,
                Arrays.asList(Balance("USD", BigDecimal.valueOf(100)), Balance("EUR", BigDecimal.valueOf(200)))))
                .block()

        log.info("saved wallet = $savedWallet")

    }

}