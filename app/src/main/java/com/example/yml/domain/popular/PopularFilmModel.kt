package com.example.yml.domain.popular

import android.graphics.Bitmap
import com.example.yml.data.popular.TrailerApi
import java.io.Serializable

data class PopularFilmModel(
//    val id: Long,
    val name: String,
    val description: String,
    val year: Int,
    val imdb: String,
    val kp: String,
    val poster: Bitmap?,
    val url: String?,
    val genre: String,
    val country: String,
    val feesValue: Long,
    //    val nameTrailer: String
) : Serializable
