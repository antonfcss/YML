package com.example.yml.presentation.features.about

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.about.AboutMovieUseCase
import com.example.yml.domain.mytop.MyTopUseCase
import com.example.yml.domain.popular.PopularFilmModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AboutMovieViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val myTopUseCase: MyTopUseCase
) : ViewModel() {

    //LiveData списка PopularFilmModel. Ниже функция с которой мы её получаем.
    private val testStringLiveData = MutableLiveData<List<PopularFilmModel>>()
    fun getMovieLiveData() = testStringLiveData

    private val isFilmInMyTop = MutableLiveData<Boolean>(false)
    fun getIsFilmInMyTopLiveData() = isFilmInMyTop

    fun isFilmIsPopular(currentFilmModel: PopularFilmModel) {
        Log.d("dsadsa121", currentFilmModel.toString())
        viewModelScope.launch {
            val filmsInDb = aboutMovieUseCase.getAllMoviesFromDataBase()
            filmsInDb.forEach {
                if (it.name == currentFilmModel.name) {
                    isFilmInMyTop.postValue(true)
                }
            }
        }
    }

    fun addToDB(popularFilmModel: PopularFilmModel) {
        //Т.к. функции в классе MovieUseCase помечены suspend(многопоточность), то мы с помощью
        //viewModelScope.launch получаем доступ к потоку.
        // viewModelScope- откуда будем запускать потом,launch-запуск coroutine
        isFilmInMyTop.postValue(false)
        viewModelScope.launch {
            aboutMovieUseCase.addMovieToDataBase(popularFilmModel)
        }
    }

    fun deleteFromDB(popularFilmModel: PopularFilmModel) {
        viewModelScope.launch {
            aboutMovieUseCase.deleteMovieFromDataBase(popularFilmModel)
        }
    }
}
