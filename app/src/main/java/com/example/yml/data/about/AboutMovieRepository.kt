package com.example.yml.data.about

import com.example.yml.data.db.MovieDatabase
import com.example.yml.data.mytop.MyTopMapper
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class AboutMovieRepository @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val myTopMapper: MyTopMapper
) {
    suspend fun getMovieFromDB(): List<PopularFilmModel> {
        return movieDatabase.aboutMovieDao().getAllMoviesFromDB()
            .map { myTopMapper.mapToDomain(it) }
    }

    suspend fun addMovieToDB(popularFilmModel: PopularFilmModel) {
        movieDatabase.aboutMovieDao().addMovieToDB(myTopMapper.mapToDb(popularFilmModel))
    }

    suspend fun deleteMovieFromDB(popularFilmModel: PopularFilmModel) {
        movieDatabase.aboutMovieDao().deleteFilm(myTopMapper.mapToDb(popularFilmModel))
    }
}