package com.tradeninja.backend.controller

import com.tradeninja.backend.model.Balance
import com.tradeninja.backend.service.WalletService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import java.math.BigDecimal


@RestController
class WalletController(val service: WalletService) {

    @GetMapping("/v1/wallet/{userId}")
    fun getUserWallet(@PathVariable userId: String,
                      @RequestParam(name = "showZeros", required = false, defaultValue = "false") showZeros: Boolean) =
            Flux.concat(
                    service.getUserWallet(userId)
                            .flatMapIterable { it.balances },
                    if (showZeros) listOf(Balance("BTC", BigDecimal(100500))).toFlux() else Flux.empty()
            )

//        listOf(Balance("BTC", BigDecimal(100500))).toFlux()
//                .concatWith { listOf(Balance("BCC", BigDecimal(300))).toFlux() }


}