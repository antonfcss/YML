package com.example.yml.data.popular

import retrofit2.http.GET
import retrofit2.http.Query

// Описываем запросы, которые нам нужны
interface PopularApi {
    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&search[]=2020-2022&search[]=!null&search[]=!null&page=1&field[]=year&field[]=name&field[]=votes.kp&limit=20&sortField[]=votes.kp&sortField[]=premiere.world&sortType[]=-1&sortType[]=-1")
    suspend fun getPopularMovies(): PopularMoviesApi

    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&field=id")
    suspend fun getMovieDetails(@Query("search") id: String): MovieDetailApiModel
}