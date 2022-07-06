package com.example.yml.presentation.features.popular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.about.AboutMovieUseCase
import com.example.yml.domain.api.ApiUseCase
import com.example.yml.domain.movie.MovieModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val apiUseCase: ApiUseCase
) : ViewModel() {

    private val testStringLiveData = MutableLiveData<List<MovieModel>>()
    fun getMovieLiveData() = testStringLiveData

    fun getData(){
        viewModelScope.launch {
            apiUseCase.getData()
        }
    }

}

