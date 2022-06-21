package com.example.yml.domain.about

import com.example.yml.data.about.AboutMovieRepository
import javax.inject.Inject

class AboutMovieUseCase @Inject constructor(
    private val aboutMovieRepository: AboutMovieRepository
) {
    //Получаем domain модельку
    fun getTestData(): AboutMovieModel {
        return aboutMovieRepository.getTestString()
    }
}