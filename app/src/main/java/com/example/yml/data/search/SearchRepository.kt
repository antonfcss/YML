package com.example.yml.data.search

import com.example.yml.data.popular.PopularMoviesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val searchApi: SearchApi
) {
    suspend fun getMoviesSearchName(movieName: String): Flow<List<PopularMoviesApi>> {
        return flow {  searchApi.funSearchMovie(movieName)}
    }
}