package com.example.app.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase


/*
* aqui definimos o nosso banco local o Room é notório que a Classe "Pessoa" é
* incorporada com entidade,e nesse banco temos a nossa 1°Versão temos o banco de dados
* */
@Database(
    entities = [Pessoa::class],
    version = 1
)

abstract class PessoaDataBase: RoomDatabase() {
    abstract fun pessoaDAO(): PessoaDAO
}