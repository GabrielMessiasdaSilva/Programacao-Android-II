package Fundamentos_Kotlin

inline fun transacao(funcao : () -> Unit )
{
    println("Abrindo transação.........LOADING ")
    try {
        funcao()
    } finally {
        println("Fechando transação")
    }
}

fun main (args: Array<String>){
    transacao {
        println("Executando SQL 1...............")
        println("Executando SQL 2...............")
        println("Executando SQL 3...............")
    }
}