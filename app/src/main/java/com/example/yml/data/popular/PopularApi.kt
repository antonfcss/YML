package com.example.yml.data.popular

import com.example.yml.data.popular.entities.MovieDetailApiModel
import com.example.yml.data.popular.entities.PopularMoviesApi
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularApi {
    @GET("movie?&search[]=2020-2022&search[]=!null&search[]=!null&page=1&field[]=year&field[]=name&field[]=votes.kp&limit=20&sortField[]=votes.kp&sortField[]=premiere.world&sortType[]=-1&sortType[]=-1")
    suspend fun getPopularMovies(@Query("token") token: String): PopularMoviesApi

    @GET("movie?&field=id")
    suspend fun getMovieDetails(
        @Query("token") token: String,
        @Query("search") id: String
    ): MovieDetailApiModel
}