package Fundamentos_Kotlin

fun main(args: Array <String>){
    val nota = 4

    when(nota){
        10,9 -> print("Fantatisco")
        8,7 -> print ("Parabéns")
        6,5,4 -> print("Tem como recuperar")
        in 3 .. 0-> print("IHH dançou , te Vejo no proximo semestre")
        else -> print("Nota Invalida")
    }
}