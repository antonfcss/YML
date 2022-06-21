package com.example.yml.domain.movie


data class MovieModel(
    val id: Long,
    val posterMovie: String,
    val title: String,
    val ratingKp: String,
    val ratingImdb: String,
    val releaseDate: String,
    val movieCountry: String,
    val movieGenre: String,
    val grossWorldwide: String,
    val shortDescriptions: String
    )