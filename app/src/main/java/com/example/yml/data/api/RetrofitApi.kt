package com.example.yml.data.api

import retrofit2.http.GET

// Описываем запросы, которые нам нужны
interface RetrofitApi {
    @GET("movie?search=Дюна&field=name&isStrict=true&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    fun getMovie(): TestApi

}