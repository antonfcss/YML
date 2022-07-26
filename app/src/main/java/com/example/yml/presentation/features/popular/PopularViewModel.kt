package com.example.yml.presentation.features.popular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.about.AboutMovieUseCase
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.domain.popular.PopularUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val popularUseCase: PopularUseCase
) : ViewModel() {

    private val testStringLiveData = MutableLiveData<List<PopularFilmModel>>()
    fun getMovieLiveData() = testStringLiveData

    private val loadingState = MutableLiveData(false)

    fun getLoadingState() = loadingState

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            popularUseCase.getData()
                .catch { e -> Log.d("dsadsa", e.toString()) }
                .collect {
                    loadingState.postValue(true)
                    testStringLiveData.postValue(it)
                }
        }
    }
}

