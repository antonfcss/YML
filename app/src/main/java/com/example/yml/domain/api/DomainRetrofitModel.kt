package com.example.yml.domain.api

import com.example.yml.data.api.KinoLogo

data class DomainRetrofitModel(
    val url: KinoLogo
)

data class KinoLogo(
    val id: String,
    val url: String)