package com.example.yml.data.popular

import com.google.gson.annotations.SerializedName

data class CountryApi(
    @SerializedName("name")
    val countryName: String
)
