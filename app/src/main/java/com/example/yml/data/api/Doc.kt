package com.example.yml.data.api

data class Doc(
    val alternativeName: String,
    val color: String,
    val description: String,
    val enName: Any,
    val externalId: ExternalId,
    val id: Int,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val poster: Poster,
    val rating: Rating,
    val shortDescription: String,
    val type: String,
    val year: Int
)