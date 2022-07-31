package com.example.yml.domain.about

import com.example.yml.data.about.AboutMovieRepository
import com.example.yml.data.mytop.MyTopRepository
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class AboutMovieUseCase @Inject constructor(
    private val aboutMovieRepository: AboutMovieRepository,
    private val myTopRepository: MyTopRepository

) {
    //Получаем domain модельку
    suspend fun addMovieToDataBase(popularFilmModel: PopularFilmModel) {
        aboutMovieRepository.addMovieToDB(popularFilmModel)
    }

    /*
      Возвращает домен модель
     */
    suspend fun getAllMoviesFromDataBase(): List<PopularFilmModel> {
        return aboutMovieRepository.getMovieFromDB()
    }

    suspend fun deleteMovieFromDataBase(popularFilmModel: PopularFilmModel) {
        aboutMovieRepository.deleteMovieFromDB(popularFilmModel)
    }
}