package com.example.yml.data.api

import com.google.gson.annotations.SerializedName

data class DocsApi(
    @SerializedName("docs")
    val docs: List<TestApi>
)
