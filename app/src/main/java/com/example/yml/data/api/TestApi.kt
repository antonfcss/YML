package com.example.yml.data.api

import com.google.gson.annotations.SerializedName

data class TestApi(
    @SerializedName("logo")
    val logo: KinoLogoApiModel
)
