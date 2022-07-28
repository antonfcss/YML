package com.example.yml.presentation.features.about

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yml.domain.about.AboutMovieUseCase
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.mytop.MyTopUseCase
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.domain.popular.PopularUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AboutMovieViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val popularUseCase: PopularUseCase,
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
