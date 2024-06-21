package com.example.app.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey
/*
é criada o dado da classe Pessoal e dentro dessa classe armazenamos as váriaveis ou seja recuperamos ele,
defindo-as como string e nosso banco local o "room" nessa classe é armazenado o a chave primaria  e o nosso Id iniciado com zero

*/

@Entity
data class Pessoa(
    val nome: String,
    val telefone: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
