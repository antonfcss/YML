package com.example.yml.presentation.features.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.data.popular.PopularMoviesApi
import com.example.yml.domain.search.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {
    private val movieSearchLiveData = MutableLiveData<List<PopularMoviesApi>>()

    fun searchForMovie(movieName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            val searchResult = searchUseCase.searchForMovie(movieName)
            movieSearchLiveData.postValue(searchResult)
        }
    }
}