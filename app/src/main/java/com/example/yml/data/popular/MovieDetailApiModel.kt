package com.example.yml.data.popular

import com.google.gson.annotations.SerializedName

data class MovieDetailApiModel(
    @SerializedName("videos")
    val videosApi: VideosApi,
    @SerializedName("genres")
    val genresApi: List<GenreApi>,
    @SerializedName("countries")
    val countriesApi: List<CountryApi>
)
