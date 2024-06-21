package com.example.app.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao // define os métodos que oferecem dados abstratos do banco room
interface PessoaDAO {

    @Upsert  //aqui inserimos o objeto e também atualizamos
    suspend fun upsertPessoa(pessoa: Pessoa)

    @Delete //essa operação de deletar o objeto
    suspend fun deletePessoa(pessoa: Pessoa)

    @Query("SELECT * FROM pessoa") //esse método seleciona os dados da entidade Pessoa
    fun getAllPessoa(): Flow<List<Pessoa>>
}