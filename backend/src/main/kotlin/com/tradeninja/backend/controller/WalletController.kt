package com.tradeninja.backend.controller

import com.tradeninja.backend.service.WalletService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class WalletController(val service: WalletService) {

    @GetMapping("/v1/wallet/{userId}")
    fun getUserWallet(@PathVariable userId: String) = service.getUserWallet(userId)

}