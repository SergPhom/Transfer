package ru.netology

import java.math.BigDecimal

fun transferInterest(amount: BigDecimal): BigDecimal {
    if(amount < 35.toBigDecimal()){
        println("Сумма перевода должна быть от 35 рублей.")
        return 0.toBigDecimal()
    }else  return amount.multiply(0.0075.toBigDecimal())
}
fun main() {
    val transferAmount = 107.50
    val interest = transferInterest(transferAmount.toBigDecimal())
    if(interest !== 0.toBigDecimal()) println("Сумма перевода - $transferAmount рублей. " +
            String.format("Сумма комиссии - %.2f рублей.", interest))
}