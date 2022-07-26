package com.example.yml.domain.search

import com.example.yml.data.popular.PopularMoviesApi
import com.example.yml.data.search.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun searchForMovie(movieName: String): Flow<List<PopularMoviesApi>> {
        return searchRepository.getMoviesSearchName(movieName)
    }
}