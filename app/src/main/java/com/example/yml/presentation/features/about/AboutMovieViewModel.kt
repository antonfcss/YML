package com.example.yml.presentation.features.about

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yml.domain.about.AboutMovieUseCase
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.api.ApiUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AboutMovieViewModel @Inject constructor(
    private val aboutMovieUseCase: AboutMovieUseCase,
    private val apiUseCase: ApiUseCase
) : ViewModel() {

   private val testStringLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    //Получаем готовую модельку из domain и достаем из нее данные
    fun test() {
        testStringLiveData.postValue(aboutMovieUseCase.getTestData().testString)
    }

    fun getTestLiveData(): LiveData<String> {
        return testStringLiveData
    }
    fun getData(){
        viewModelScope.launch {
            apiUseCase.getData()
                .catch { exception -> Log.d("dsadsa", exception.toString()) }
                .collect { domainRetrofitModel ->
                    testStringLiveData.postValue(domainRetrofitModel.url.toString())
                }
        }
    }
}