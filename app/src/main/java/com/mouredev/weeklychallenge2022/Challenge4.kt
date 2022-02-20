package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
sealed class Polygon{
    data class Triangle(
        val base: Int,
        val height: Int
    ) : Polygon()

    data class Square(
        val side: Int
    ): Polygon()

    data class Rectangle(
        val base: Int,
        val height: Int
    ) : Polygon()
}

fun main(){
    val rectangle = Polygon.Rectangle(15, 7)
    println("Rectangle with $rectangle area is ${calculateArea(rectangle)}")
    val triangle = Polygon.Triangle(12, 15)
    println("Triangle with $triangle area is ${calculateArea(triangle)}")
    val square = Polygon.Square(12)
    println("Square with $square area is ${calculateArea(square)}")
}

private fun calculateArea(polygon: Polygon) : Int =
    when(polygon){
        is Polygon.Rectangle -> polygon.base * polygon.height
        is Polygon.Square -> polygon.side * polygon.side
        is Polygon.Triangle -> (polygon.base * polygon.height)/2
    }

