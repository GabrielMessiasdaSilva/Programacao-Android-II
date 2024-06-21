package Exercicios_Parte2

inline fun transacao(funcao: () -> Unit){
    println("Abrindo transação...")
    try{
        funcao()
    }finally {
        println("fechando transação")
    }
}
fun main(args: Array<String>){
    transacao {
        println("Executando sql1...")
        println("Executando sql2...")
        println("Executando sql3...")
    }
}