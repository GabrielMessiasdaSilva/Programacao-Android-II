package Exercicios_Parte2.Projeto_Calculando_Areas

import kotlin.math.PI
import kotlin.math.pow

fun main() {
    println("Calculadora de Áreas  Geométricas")
    println("Selecione as opções geométrica desejada para calcular:")
    println("1. Retângulo")
    println("2. Triângulo")
    println("3. Circunferência")
    println("4. Losango")
    println("5. Trapézio")

    val escolha = readLine()?.toInt() ?: 0

    when (escolha) {
        1 -> calcularAreaRetangulo()
        2 -> calcularAreaTriangulo()
        3 -> calcularAreaCircunferencia()
        4 -> calcularAreaLosango()
        5 -> calcularAreaTrapezio()
        else -> println("Opção inválida!")
    }
}

fun calcularAreaRetangulo() {
    println("Digite a base do retângulo:")
    val base = readLine()!!.toDouble()
    println("Digite a altura do retângulo:")
    val altura = readLine()!!.toDouble()
    println("A área do retângulo é: ${base * altura}")
}

fun calcularAreaTriangulo() {
    println("Digite a base do triângulo:")
    val base = readLine()!!.toDouble()
    println("Digite a altura do triângulo:")
    val altura = readLine()!!.toDouble()
    println("A área do triângulo é: ${0.5 * base * altura}")
}

fun calcularAreaCircunferencia() {
    println("Digite o raio da circunferência:")
    val raio = readLine()!!.toDouble()
    println("A área da circunferência é: ${PI * raio.pow(2)}")
}

fun calcularAreaLosango() {
    println("Digite a diagonal maior do losango:")
    val diagonalMaior = readLine()!!.toDouble()
    println("Digite a diagonal menor do losango:")
    val diagonalMenor = readLine()!!.toDouble()
    println("A área do losango é: ${(diagonalMaior * diagonalMenor) / 2}")
}

fun calcularAreaTrapezio() {
    println("Digite a base maior do trapézio:")
    val baseMaior = readLine()!!.toDouble()
    println("Digite a base menor do trapézio:")
    val baseMenor = readLine()!!.toDouble()
    println("Digite a altura do trapézio:")
    val altura = readLine()!!.toDouble()
    println("A área do trapézio é: ${((baseMaior + baseMenor) / 2) * altura}")
}
