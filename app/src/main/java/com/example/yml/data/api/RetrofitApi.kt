package com.example.yml.data.api

import retrofit2.http.GET

// Описываем запросы, которые нам нужны
interface RetrofitApi {
    @GET("movie?search=Дюна&field=name&isStrict=true&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    suspend fun getMovie(): DocsApi

    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&search[]=2020-2022&search[]=!null&search[]=!null&page=1&field[]=year&field[]=name&field[]=votes.kp&limit=20&sortField[]=votes.kp&sortField[]=premiere.world&sortType[]=-1&sortType[]=-1")
    suspend fun getPopularMovies(): PopularMoviesApi

}