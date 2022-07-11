package com.example.yml.domain.api

import com.example.yml.data.api.RetrofitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApiUseCase @Inject constructor(
    private val retrofitRepository: RetrofitRepository
) {
    fun getData(): Flow<List<DomainRetrofitModel>>{
        return retrofitRepository.getDataFromRemote()
    }
}