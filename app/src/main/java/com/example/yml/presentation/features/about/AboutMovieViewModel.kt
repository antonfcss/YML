package com.example.yml.presentation.features.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yml.domain.AboutMovieUseCase
import javax.inject.Inject
import androidx.lifecycle.LiveData

class AboutMovieViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase
) : ViewModel() {

   private val testStringLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    //Получаем готовую модельку из domain и достаем из нее данные
    fun test() {
        testStringLiveData.postValue(aboutMovieUseCase.getTestData().testString)
    }

    fun getTestLiveData(): LiveData<String> {
        return testStringLiveData
    }


    //Перевести функцию test() на liveData
}