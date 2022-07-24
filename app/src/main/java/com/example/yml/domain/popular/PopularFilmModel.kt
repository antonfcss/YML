package com.example.yml.domain.popular

import android.graphics.Bitmap
import java.io.Serializable

data class PopularFilmModel(
    val name: String,
    val description: String,
    val year: Int,
    val imdb: String,
    val kp: String,
    val poster: Bitmap?
): Serializable
