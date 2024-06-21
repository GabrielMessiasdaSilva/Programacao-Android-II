package Fundamentos_Kotlin

inline  fun  <T> executarComLog(nomeFuncao:String,funcao : ()-> T): T {
    println("Entrando no método $nomeFuncao....")
    try {
        return funcao()
    } finally {
        println("Metodo $nomeFuncao finalizado ...")
    }
}

fun somar(a: Int , b: Int): Int {
    return a+b
}
fun main(args: Array<String>){
    val resultados = executarComLog("somar"){
        somar(4,5)
    }

    println(resultados)
}