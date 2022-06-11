package com.example.yml.presentation.features.about

import androidx.lifecycle.ViewModel
import com.example.yml.data.AboutMovieMapper
import com.example.yml.domain.AboutMovieUseCase
import javax.inject.Inject

class AboutMovieViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase
) : ViewModel() {
    //Получаем готовую модельку из domain и достаем из нее данные
    fun test(): String {
        return aboutMovieUseCase.getTestData().testString
    }
    //Перевести функцию test() на liveData
}