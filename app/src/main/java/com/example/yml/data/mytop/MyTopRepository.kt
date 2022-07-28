package com.example.yml.data.mytop

import com.example.yml.data.db.MovieDatabase
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class MyTopRepository @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val myTopMapper: MyTopMapper
) {
    /*Функция для чтения.Получаем List<MovieDataBaseModel> из getAllMoviesFromDB
 Возвращаем List<MovieModel> список обычных моделек для работы с приложением
 */
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
}