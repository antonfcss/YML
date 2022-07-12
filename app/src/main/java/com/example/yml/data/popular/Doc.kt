package com.example.yml.data.popular

data class Doc(
    val alternativeName: String,
    val description: String,
    val id: Int,
    val movieLength: Int,
    val name: String,
    val poster: Poster,
    val rating: Rating,
    val year: Int
)