package com.example.yml.data.popular

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String
)
