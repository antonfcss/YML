package com.example.yml.data.search

import com.example.yml.data.popular.entities.PopularMoviesApi
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("movie?&field=name&isStrict=true")
    suspend fun funSearchMovie(
        @Query("token") token: String,
        @Query("search") movie: String
    ): PopularMoviesApi
}