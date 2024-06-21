package com.example.app.viewModel

import com.example.app.roomDB.Pessoa
import com.example.app.roomDB.PessoaDataBase


//aqui dentro dessa classe há a chamada e modelagem de cada ação puxada do Pessoa database,ou seja há manipulação além disso como a as operações upsert e delete
class Repository(private val db: PessoaDataBase) {
    suspend fun upsertPessoa(pessoa: Pessoa){
        db.pessoaDAO().upsertPessoa(pessoa)
    }

    suspend fun deletePessoa(pessoa: Pessoa){
        db.pessoaDAO().deletePessoa(pessoa)
    }
    fun getAllPessoa() = db.pessoaDAO().getAllPessoa()

}