package com.mouredev.weeklychallenge2022

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue
import kotlin.time.Duration.Companion.days

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */



fun main() {
    println("Welcome to dates difference calculator.")
    println("Introduce first date: ")
    val dateOne = readLine()
    dateOne?.validateDateFormat()
    println("Introduce second date: ")
    val dateTwo = readLine()
    dateTwo?.validateDateFormat()
    println("The different between $dateOne and $dateTwo is ...")
    if (dateOne != null && dateTwo != null) {
        println("${calculateDateDifferences(dateOne.parseToDate(), dateTwo.parseToDate())}")
    }

}

private fun String.parseToDate(): Date{
    val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    return dateFormat.parse(this)?: throw Exception("Invalid format exception")
}


private fun String.validateDateFormat() :String = if (matches(DATE_REGEX.toRegex())){
    this
}else{
    throw IllegalArgumentException("Not valid date format")
}


private fun calculateDateDifferences(dateOne: Date, dateTwo: Date): Int =
    TimeUnit.DAYS.convert(
        dateOne.time - dateTwo.time, TimeUnit.MILLISECONDS
    ).toInt().absoluteValue

private const val DATE_REGEX = "^([0-2][0-9]|3[0-1])(/)(0[1-9]|1[0-2])\\2(\\d{4})\$"

private const val DATE_FORMAT = "dd/MM/yyyy"