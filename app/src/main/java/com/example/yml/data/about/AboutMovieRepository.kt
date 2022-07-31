package com.example.yml.data.about

import com.example.yml.data.db.MovieDatabase
import com.example.yml.data.mytop.MyTopMapper
import com.example.yml.domain.about.AboutMovieModel
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class AboutMovieRepository @Inject constructor(
    private val aboutMovieDataSource: AboutMovieDataSource,
    private val aboutMovieMapper: AboutMovieMapper,
    private val movieDatabase: MovieDatabase,
    private val myTopMapper: MyTopMapper
) {
    //Тут мы "ходим" в сеть за данными и превращаем их в сущность слоя domain
    fun getTestString(): AboutMovieModel {
        return aboutMovieMapper.mapToDomain(aboutMovieDataSource.getTestData())
    }

    suspend fun getMovieFromDB(): List<PopularFilmModel> {
        return movieDatabase.aboutMovieDao().getAllMoviesFromDB()
            .map { myTopMapper.mapToDomain(it) }
    }

    /*
    Принимаем модель MovieModel(модель не база данных) и отправяет в db базу данных с помощью moviesMapper
     */
    suspend fun addMovieToDB(popularFilmModel: PopularFilmModel) {
        movieDatabase.aboutMovieDao().addMovieToDB(myTopMapper.mapToDb(popularFilmModel))
    }

    suspend fun deleteMovieFromDB(popularFilmModel: PopularFilmModel) {
        movieDatabase.aboutMovieDao().deleteFilm(myTopMapper.mapToDb(popularFilmModel))
    }
}