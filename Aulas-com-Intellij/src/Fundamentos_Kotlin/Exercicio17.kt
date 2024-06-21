package Fundamentos_Kotlin

fun main(args: Array <String>){
    val alunos = arrayListOf("Gabriel", "André", "Marcos")
    for ((indice, alunos) in alunos.withIndex()) {
        println("$indice - $alunos \n ")
    }

}

