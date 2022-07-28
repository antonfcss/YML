package com.example.yml.domain.mytop

import com.example.yml.data.mytop.MyTopRepository
import com.example.yml.domain.popular.PopularFilmModel
import javax.inject.Inject

class MyTopUseCase @Inject constructor(
    private val myTopRepository: MyTopRepository
) {
    suspend fun addMovieToDataBase(popularFilmModel: PopularFilmModel) {
        myTopRepository.addMovieToDB(popularFilmModel)
    }

    /*
      Возвращает домен модель
     */
    suspend fun getAllMoviesFromDataBase(): List<PopularFilmModel> {
        return myTopRepository.getMovieFromDB()
    }
}