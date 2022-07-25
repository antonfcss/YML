package com.example.yml.data.popular

import com.google.gson.annotations.SerializedName

data class TrailerApi(
    val url: String,
    @SerializedName("name")
    val nameTrailer: String
)
