package com.example.yml.domain

import com.example.yml.data.AboutMovieRepository
import javax.inject.Inject

class AboutMovieUseCase @Inject constructor(
    private val aboutMovieRepository: AboutMovieRepository
) {
    //Получаем domain модельку
    fun getTestData(): AboutMovieModel {
        return aboutMovieRepository.getTestString()
    }
}