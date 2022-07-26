package com.example.yml.data.search

import com.example.yml.data.popular.PopularMoviesApi
import retrofit2.http.GET
import retrofit2.http.Query

//Для примера взял PopularMoviesApi так как поля приходят одинаковые.
interface SearchApi  {
    @GET("movie?token=7X7WT21-YV24K75-N5EH7ZQ-JJV83W9&field=name&isStrict=true")
    suspend fun funSearchMovie(@Query("search") movie: String): PopularMoviesApi
}