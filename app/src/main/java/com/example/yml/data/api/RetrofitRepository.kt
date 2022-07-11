package com.example.yml.data.api

import com.example.yml.domain.api.DomainRetrofitModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Репозиторий где мы работаем с описанымми запросами из RetrofitApi.
// Чтобы их получить мы провайдем интерфейс RetrofitApi с помощью @Inject constructor.
// Благодаря этому у нас видны все методы интерфейса. Flow класс Coroutines, который описывает поток
// emit то что мы прокидываем в Flow
class RetrofitRepository @Inject constructor(
    private val retrofitApi: RetrofitApi
) {
    fun getDataFromRemote(): Flow<List<DomainRetrofitModel>> {
//        return flow { emit(RetrofitMapper.mapToDomain(retrofitApi.getMovie())) }
        return flow {
            val retrofitModel = retrofitApi.getPopularMovies()
            val outputList = arrayListOf<DomainRetrofitModel>()
            retrofitModel.docs.forEach{
                outputList.add(DomainRetrofitModel(it.name,it.poster))
            }
            emit(outputList)
        }
    }
}