package com.example.yml.data.movie

import com.example.yml.data.db.MovieDatabase
import com.example.yml.domain.movie.MovieModel
import javax.inject.Inject

/*
 Опракидываем db созданую в DataModule. Главная задача репозитория сделать из модели данных
 MovieDataBaseModel, сделать модель данных с которым будет рабоать приложение MovieModule
 */
class MovieRepository @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val moviesMapper: MoviesMapper
) {
    /*Функция для чтения.Получаем List<MovieDataBaseModel> из getAllMoviesFromDB
     Возвращаем List<MovieModel> список обычных моделек для работы с приложением
     */
    suspend fun getMovieFromDB(): List<MovieModel> {
        return movieDatabase.aboutMovieDao().getAllMoviesFromDB()
            .map { moviesMapper.mapToDomain(it) }
    }


    /*
    Принимаем модель MovieModel(модель не база данных) и отправяет в db базу данных с помощью moviesMapper
     */
    suspend fun addMovieToDB(movieModel: MovieModel) {
        movieDatabase.aboutMovieDao().addMovieToDB(moviesMapper.mapToDb(movieModel))
    }
}