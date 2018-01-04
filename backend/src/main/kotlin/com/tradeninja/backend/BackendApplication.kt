package com.tradeninja.backend

import com.tradeninja.backend.model.Balance
import com.tradeninja.backend.model.User
import com.tradeninja.backend.model.Wallet
import com.tradeninja.backend.repository.UserRepository
import com.tradeninja.backend.repository.WalletRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.math.BigDecimal.valueOf
import java.util.Arrays.asList

@SpringBootApplication
class BackendApplication {
}

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
