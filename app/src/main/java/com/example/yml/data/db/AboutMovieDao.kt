package com.example.yml.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  AboutMovieDao {
    @Insert
    suspend fun addMovieToDB(mapToDb: MovieDataBaseModel)

    @Query("SELECT * FROM movies")
    suspend fun getAllMoviesFromDB(): List<MovieDataBaseModel>

    @Delete
    suspend fun deleteFilm(movieDataBaseModel: MovieDataBaseModel)


}