package com.tradeninja.backend

import com.tradeninja.backend.config.ProxyConfig
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BackendApplication {


    @Bean
    fun checkConfig(proxyConfig: ProxyConfig) = CommandLineRunner {
        print(proxyConfig.hosts)
    }
}

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
