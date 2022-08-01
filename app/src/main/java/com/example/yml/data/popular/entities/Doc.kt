package com.example.yml.data.popular.entities

import com.google.gson.annotations.SerializedName

data class Doc(
    val description: String?,
    val id: Int,
    val movieLength: Int,
    val name: String,
    @SerializedName("poster")
    val posterApiModel: PosterApiModel,
    val rating: Rating,
    val year: Int
)