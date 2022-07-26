package com.example.yml.presentation.features.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.data.popular.PopularMoviesApi
import com.example.yml.domain.search.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {
    private val movieSearchLiveData = MutableLiveData<List<PopularMoviesApi>>()
    fun getMovieSearchLiveData() = movieSearchLiveData

    fun searchForMovie(movieName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            searchUseCase.searchForMovie(movieName)
                .catch { e -> Log.d("dsadsa", e.toString()) }
                .collect {
                    movieSearchLiveData.postValue(it)
                }
        }
    }
}