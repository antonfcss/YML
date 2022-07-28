package com.example.yml.presentation.features.mytop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.mytop.MyTopUseCase
import com.example.yml.domain.popular.PopularFilmModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyTopViewModel @Inject constructor(
    private val myTopUseCase: MyTopUseCase
) : ViewModel() {
    //LiveData списка PopularFilmModel. Ниже функция с которой мы её получаем.
    private val testStringLiveData = MutableLiveData<List<PopularFilmModel>>()
    fun getMovieLiveData() = testStringLiveData

    fun loadMoviesListToLog() {
        viewModelScope.launch {
            testStringLiveData.postValue(myTopUseCase.getAllMoviesFromDataBase())
        }
    }

    fun addToDB(popularFilmModel: PopularFilmModel) {
        //Т.к. функции в классе MovieUseCase помечены suspend(многопоточность), то мы с помощью
        //viewModelScope.launch получаем доступ к потоку.
        // viewModelScope- откуда будем запускать потом,launch-запуск coroutine
        viewModelScope.launch {
            myTopUseCase.addMovieToDataBase(popularFilmModel)
        }
    }
}