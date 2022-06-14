package com.example.yml.data.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AboutMovieDao {

    @Query("SELECT * FROM movie WHERE id=:id")
    fun getMovieById(id: Long): Movie?

    @Query("DELETE FROM movie")
    fun deleteAll()
}