package com.example.yml.domain.popular

import android.graphics.Bitmap
import com.example.yml.data.popular.TrailerApi
import java.io.Serializable

data class PopularFilmModel(
    val name: String,
    val description: String,
    val year: Int,
    val imdb: String,
    val kp: String,
    val poster: Bitmap?,
    val url: String,
    val genre: List<String>,
    val country: List<String>
) : Serializable
