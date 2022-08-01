package com.example.yml.presentation.features.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.domain.search.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {
    private val movieSearchLiveData = MutableLiveData<List<PopularFilmModel>>()
    fun getMovieSearchLiveData() = movieSearchLiveData

    fun searchForMovie(movieName: String) {
        Log.d("dsadsaSearch", movieName)
        viewModelScope.launch(Dispatchers.IO) {
            searchUseCase.searchForMovie(movieName)
                .catch { e -> Log.d("dsadsaSearch", e.toString()) }
                .collect {
                    Log.d("dsadsaSearch", it.toString())
                    movieSearchLiveData.postValue(it)
                }
        }
    }
}