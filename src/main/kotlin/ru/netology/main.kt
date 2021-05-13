package ru.netology

import java.math.BigDecimal

enum class cardType(val nameOfCard: String){
    MAESTRO("Maestro"),
    MASTERCARD("Mastercard"),
    VISA("Visa"),
    MIR("Мир"),
    VKPAY("VK Pay")
}
fun typeOfCard(type: String?): cardType{
    val allTypes = cardType.values()
    for(t in allTypes){
        if(t.nameOfCard.equals(type)) return t
    }
    return cardType.VKPAY
}

fun transferInterest(
    typeOfCard: cardType = cardType.VKPAY,
    previousAmount: BigDecimal = 0.toBigDecimal(),
    amount: BigDecimal
): BigDecimal =
    when(typeOfCard){
        cardType.MAESTRO, cardType.MASTERCARD -> {
            if(previousAmount in 300.toBigDecimal()..75000.toBigDecimal()){
                0.toBigDecimal()
            }else amount.multiply(0.006.toBigDecimal()) + 20.toBigDecimal()
        }
        cardType.MIR, cardType.VISA -> {
            val visaPercentage =amount.multiply(0.0075.toBigDecimal())
            if(visaPercentage.compareTo(35.toBigDecimal()) > 0) {
                visaPercentage
            }else 35.toBigDecimal()
        }
        else -> 0.toBigDecimal()
    }

fun main() {
    val transferAmount = 107.50
    val previousAmount = 150
    val cardType = "Maestro"
    val result = transferInterest(
        typeOfCard = typeOfCard(cardType),
        previousAmount = previousAmount.toBigDecimal(),
        amount = transferAmount.toBigDecimal())
    val interestOutput = String.format("Сумма комиссии - %.2f рублей.", result)
    println("Сумма перевода - $transferAmount рублей.  $interestOutput")
}