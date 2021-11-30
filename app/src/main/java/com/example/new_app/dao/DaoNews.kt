package com.example.new_app.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.new_app.adaptador.database.NewEntity
import com.example.new_app.model.Articulo


@Dao
interface DaoNews {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(Lista: List<NewEntity>)


    @Query("SELECT * FROM articles")
    fun getNoticias(): LiveData<List<Articulo>>

}