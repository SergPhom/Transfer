package ru.netology

import java.math.BigDecimal

fun transferInterest(amount: BigDecimal): BigDecimal {
    val interest = amount.multiply(0.0075.toBigDecimal())
    return if(interest.compareTo(35.toBigDecimal()) <= 0){
        35.toBigDecimal()
    }else interest
}
fun main() {
    val transferAmount = 107.50
    val interest = transferInterest(transferAmount.toBigDecimal())
    val interestOutput = String.format("Сумма комиссии - %.2f рублей.", interest)
    println("Сумма перевода - $transferAmount рублей.  $interestOutput")
}