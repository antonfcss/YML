package com.example.yml.data.search

import com.example.yml.data.popular.PopularMoviesApi
import retrofit2.http.GET

//Для примера взял PopularMoviesApi так как поля приходят одинаковые.
interface SearchApi  {
    @GET("movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&search=Аватар&field=name&isStrict=true")
    suspend fun funSearchMovie(movie: String): List<PopularMoviesApi>
}