package com.tradeninja.backend.model

import java.math.BigDecimal

data class Balance(val currency: String, val balance: BigDecimal) {
    operator fun plus(balance: Balance): Balance {
        checkCurrency(balance)
        return Balance(currency, this.balance + balance.balance)
    }

    operator fun minus(balance: Balance): Balance {
        checkCurrency(balance)
        if (this.balance < balance.balance) {
            throw UnsupportedOperationException("Not enough balance")
        }
        return Balance(currency, this.balance - balance.balance)
    }


    private fun checkCurrency(balance: Balance) {
        if (balance.currency != currency) {
            throw UnsupportedOperationException("Can't add ${balance.currency} to $currency")
        }
    }
}
