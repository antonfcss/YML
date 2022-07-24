package com.example.yml.data.popular

import android.graphics.Bitmap
import com.example.yml.domain.popular.PopularFilmModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Репозиторий где мы работаем с описанымми запросами из RetrofitApi.
// Чтобы их получить мы провайдем интерфейс PopularApi с помощью @Inject constructor.
// Благодаря этому у нас видны все методы интерфейса. Flow класс Coroutines, который описывает поток
// emit то что мы прокидываем в Flow
class PopularRepository @Inject constructor(
    private val popularApi: PopularApi
) {
    suspend fun getDataFromRemote(): Flow<List<PopularFilmModel>> {
        return flow {
            val retrofitModel = popularApi.getPopularMovies()
            val outputList = arrayListOf<PopularFilmModel>()
            retrofitModel.docs.forEach {
                outputList.add(
                    PopularFilmModel(
                        it.name,
                        it.description,
                        it.year,
                        it.rating.imdb,
                        it.rating.kp,
                        getImageFromRemote(it.posterApiModel.url)
                    )
                )
            }
            emit(outputList)
        }
    }

    private suspend fun getImageFromRemote(url: String): Bitmap? {
        return Picasso.get().load(url).get()
    }
}