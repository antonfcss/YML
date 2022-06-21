package com.example.yml.presentation.features.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.movie.MovieModel
import com.example.yml.domain.movie.MovieUseCase
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {
    //LiveData списка MovieModel. Ниже функция с которой мы её получаем.
    private val testStringLiveData = MutableLiveData<List<MovieModel>>()
    fun getMovieLiveData() = testStringLiveData

    //Функция загружает лист в логи.
    fun loadMoviesListToLog() {
        viewModelScope.launch {
            testStringLiveData.postValue(movieUseCase.getAllMoviesFromDataBase())
        }
    }
    //
    fun addRandomMovieToDB() {
        //Создаём переменную, которая генерирует рандомную модель.Для теста
        val randomMovie = MovieModel(
            (0..100).random().toLong(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols(),
            getRandomSymbols()
        )
        //Т.к. функции в классе MovieUseCase помечены suspend(многопоточность), то мы с помощью
        //viewModelScope.launch получаем доступ к потоку.
        // viewModelScope- откуда будем запускать потом,launch-запуск coroutine
        viewModelScope.launch {
            movieUseCase.addMovieToDataBase(randomMovie)
        }
    }

    private fun getRandomSymbols(): String {
        val r = Random()
        val rus = "абвгдеёжзийклмнопрстуфхцчъыьэюя"
        val eng = "abcdefghijklmnopqrstuvwxyz"
        val dig = "0123456789"
        val sum = rus + rus.uppercase(Locale.getDefault()) +
                eng + eng.uppercase(Locale.getDefault()) +
                dig
        return sum[r.nextInt(sum.length)].toString()
    }
}