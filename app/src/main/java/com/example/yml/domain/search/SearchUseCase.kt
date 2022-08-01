package com.example.yml.domain.search

import com.example.yml.data.search.SearchRepository
import com.example.yml.domain.popular.PopularFilmModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun searchForMovie(movieName: String): Flow<List<PopularFilmModel>> {
        return searchRepository.getMoviesSearchName(movieName)
    }
}