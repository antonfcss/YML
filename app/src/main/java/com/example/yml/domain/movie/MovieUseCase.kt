package com.example.yml.domain.movie

import com.example.yml.data.movie.MovieRepository
import javax.inject.Inject

/* Откуда и что дёрнуть. Мы показываем с какой моделью мы рабоаем.
Тут мы получаем класс приложения и отправляем класс приложения. Сдем мы работаем только с моедль данных
прилоежния MovieModel, которая в свою очередь
    */
class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    /*
    Принимаем домен модель
     */
    suspend fun addMovieToDataBase(movieModel: MovieModel) {
        movieRepository.addMovieToDB(movieModel)
    }

    /*
      Возвращает домен модель
     */
    suspend fun getAllMoviesFromDataBase(): List<MovieModel> {
        return movieRepository.getMovieFromDB()
    }
}