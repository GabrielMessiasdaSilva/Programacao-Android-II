package Exercicios_Parte2

// Define uma função 'executarComLog' que recebe o nome da função e uma função lambda como parâmetros.
inline fun <T> executarComLog(nomeFuncao: String, funcao: () -> T): T {
    // Imprime uma mensagem indicando a entrada na função com o nome especificado.
    println("Entrando no método $nomeFuncao")
    try {
        // Chama a função lambda passada como parâmetro e retorna seu resultado.
        return funcao()
    } finally {
        // Imprime uma mensagem indicando que o método com o nome especificado está finalizando.
        println("Método $nomeFuncao finalizando...")
    }
}

// Define uma função 'somar' que retorna a soma de dois inteiros.
fun somarr(a: Int, b: Int): Int {
    return a + b
}

// Função principal 'main'
fun main(args: Array<String>) {
    // Chama a função 'executarComLog' passando "somar" como nome da função e uma lambda que chama a função 'somar' com os argumentos 4 e 5.
    // O resultado da chamada é atribuído à variável 'resultado'.
    val resultado = executarComLog("somar") {
        somarr(4, 5)
    }
    // Imprime o resultado retornado pela função 'executarComLog'.
    println(resultado)
}
