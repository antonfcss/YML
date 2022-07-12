package com.example.yml.data.popular

import com.example.yml.data.popular.PopularMoviesApi
import retrofit2.http.GET

// Описываем запросы, которые нам нужны
interface PopularApi {
    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&search[]=2020-2022&search[]=!null&search[]=!null&page=1&field[]=year&field[]=name&field[]=votes.kp&limit=20&sortField[]=votes.kp&sortField[]=premiere.world&sortType[]=-1&sortType[]=-1")
    suspend fun getPopularMovies(): PopularMoviesApi
}