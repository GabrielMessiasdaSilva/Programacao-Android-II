package Fundamentos_Kotlin

fun main(args: Array<String>){
  val nota = 9
    
    //usando o operador Range

if(nota in 9 .. 10){
    println("Fantástico !! ")

 } else if (nota in 7 .. 8){
     println("Parabens")
 }
else if (nota in 4 .. 6){
    println("tem como recuperar")
} else if (nota in 0 .. 3) {
    println("ihh rapaz,dançou ! Te vejo no proximo ano")
} else{
    println("Nota Invalida")
}

}