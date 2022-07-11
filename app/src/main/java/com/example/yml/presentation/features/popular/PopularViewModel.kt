package com.example.yml.presentation.features.popular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.about.AboutMovieUseCase
import com.example.yml.domain.api.ApiUseCase
import com.example.yml.domain.api.DomainRetrofitModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val apiUseCase: ApiUseCase
) : ViewModel() {

    private val testStringLiveData = MutableLiveData<List<DomainRetrofitModel>>()
    fun getMovieLiveData() = testStringLiveData

    fun getData() {
        viewModelScope.launch {
            apiUseCase.getData().catch { e -> Log.d("dsadsa", e.toString()) }.collect {
                testStringLiveData.postValue(it)
            }
        }
    }
}

