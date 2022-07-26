package com.example.yml.data.search

import android.graphics.Bitmap
import com.example.yml.data.popular.PopularApi
import com.example.yml.data.popular.PopularMoviesApi
import com.example.yml.domain.popular.PopularFilmModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val searchApi: SearchApi,
    private val popularApi: PopularApi
) {
    suspend fun getMoviesSearchName(movieName: String): Flow<List<PopularFilmModel>> {
        return flow { val outputList = arrayListOf<PopularFilmModel>()
            val retrofitModel = searchApi.funSearchMovie(movieName)
            retrofitModel.docs.forEach { it ->
                val detailApiModel = popularApi.getMovieDetails(it.id.toString())
                outputList.add(
                    PopularFilmModel(
                        it.name,
                        it.description,
                        it.year,
                        it.rating.imdb.format(1),
                        it.rating.kp.format(1),
                        getImageFromRemote(it.posterApiModel.url),
                        detailApiModel.videosApi.trailerApis
                            .find { it.nameTrailer.contains("Трейлер") && it.url.contains("youtube") }?.url,
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
    }
