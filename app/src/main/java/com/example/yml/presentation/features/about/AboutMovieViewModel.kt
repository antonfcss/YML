package com.example.yml.presentation.features.about

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

    private val testStringLiveData = MutableLiveData<List<PopularFilmModel>>()
    fun getMovieLiveData() = testStringLiveData

    private val isFilmInMyTop = MutableLiveData<Boolean>(false)
    fun getIsFilmInMyTopLiveData() = isFilmInMyTop

    fun isFilmIsPopular(currentFilmModel: PopularFilmModel) {
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
        viewModelScope.launch {
            aboutMovieUseCase.addMovieToDataBase(popularFilmModel)
            isFilmInMyTop.postValue(true)
        }
    }

    fun deleteFromDB(popularFilmModel: PopularFilmModel) {
        viewModelScope.launch {
            aboutMovieUseCase.deleteMovieFromDataBase(popularFilmModel)
            isFilmInMyTop.postValue(false)
        }
    }
}
