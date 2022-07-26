package com.example.yml.data.search

import com.example.yml.data.popular.PopularMoviesApi
import retrofit2.http.GET
import retrofit2.http.Query

//Для примера взял PopularMoviesApi так как поля приходят одинаковые.
interface SearchApi  {
    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&field=name&isStrict=true")
    suspend fun funSearchMovie(@Query("search") movie: String): List<PopularMoviesApi>
}