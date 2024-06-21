package Fundamentos_Kotlin

fun main(args:Array<String>){
    //Tipos Numericos inteiro com Kotlin

    val num1: Byte = 127 // 1 byte = 8 bits
    val num2: Short = 32767
    val num3: Int = 2_147_483_647
    val num4: Long = 9_223_372_036_854_775_807 //  O valor Maximo

//tipos Numericos reais
    val num5: Float= 3.14F
    val num6 : Double = 3.14
//tipo de Caracter
    val char : Char = '?' //Outros exemplos... '1','g','' o qual recebe somente um caracter

//tipo bollean

    val boolean : Boolean = true //or false

    println(listOf(num1, num2, num3, num4,num5,num6,char, boolean))
    println(2 is Int)
    println(2147483648 is Long)
    println(1.0  is Double)

//tudo é objeto
    print(10.dec())
}