package com.example.yml.data.popular

import com.google.gson.annotations.SerializedName

data class VideosApi(
    @SerializedName("trailers")
    val trailerApis: List<TrailerApi>?
)

