package com.example.yml.domain.popular

import com.example.yml.data.popular.PopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    private val retrofitRepository: PopularRepository
) {
    suspend fun getData(): Flow<List<PopularFilmModel>> {
        return retrofitRepository.getDataFromRemote()
    }
}