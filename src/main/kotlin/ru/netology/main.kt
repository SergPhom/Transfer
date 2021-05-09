package ru.netology

import java.math.BigDecimal

fun transferInterest(amount: BigDecimal): BigDecimal {
    val amount: BigDecimal = amount
    return amount.multiply(0.75.toBigDecimal())
}