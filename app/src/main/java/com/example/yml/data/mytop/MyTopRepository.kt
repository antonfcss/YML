package com.example.yml.data.mytop

import com.example.yml.data.db.MovieDatabase
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class MyTopRepository @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val myTopMapper: MyTopMapper
) {
    suspend fun getMovieFromDB(): List<PopularFilmModel> {
        return movieDatabase.aboutMovieDao().getAllMoviesFromDB()
            .map { myTopMapper.mapToDomain(it) }
    }
}