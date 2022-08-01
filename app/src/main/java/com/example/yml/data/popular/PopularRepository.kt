package com.example.yml.data.popular

import android.graphics.Bitmap
import com.example.yml.domain.popular.PopularFilmModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularRepository @Inject constructor(
    private val popularApi: PopularApi

) {
    suspend fun getDataFromRemote(): Flow<List<PopularFilmModel>> {
        return flow {
            val outputList = arrayListOf<PopularFilmModel>()
            val retrofitModel = popularApi.getPopularMovies(token)
            retrofitModel.docs.forEach { it ->
                val detailApiModel = popularApi.getMovieDetails(token, it.id.toString())
                outputList.add(
                    PopularFilmModel(
                        it.name,
                        it.description ?: "Описания нет",
                        it.year,
                        it.rating.imdb.format(1),
                        it.rating.kp.format(1),
                        getImageFromRemote(it.posterApiModel.url),
                        //Для дополнительной сортировки  it.nameTrailer.contains("Трейлер") && ,
                        // но работает не совсем корректно
                        detailApiModel.videosApi?.trailerApis
                            ?.find { it.url.contains("youtube") }?.url,
                        formatApiToString(detailApiModel.genresApi.map { it.genreName }),
                        formatApiToString(detailApiModel.countriesApi.map { it.countryName }),
                        detailApiModel.feesApi?.worldApi?.valueFees ?: 0
                    )
                )
            }
            emit(outputList)
        }
    }


    private suspend fun getImageFromRemote(url: String): Bitmap? {
        return Picasso.get().load(url).get()
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)

    private fun formatApiToString(list: List<String>): String {
        var string = ""
        for (i in list.indices) {
            if (i == list.size - 1) {
                string += list[i] + "."
                return string
            }
            string += list[i] + ", "
        }
        return string
    }

    companion object {
        private const val token = com.example.yml.BuildConfig.token
    }
}