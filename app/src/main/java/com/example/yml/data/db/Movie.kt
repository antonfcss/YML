package com.example.yml.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "poster_movie") val posterMovie: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "rating_kp") val ratingKp: String,
    @ColumnInfo(name = "rating_imdb") val ratingImdb: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "movie_country") val movieCountry: String,
    @ColumnInfo(name = "movie_genre") val movieGenre: String,
    @ColumnInfo(name = "gross_worldwide") val grossWorldwide: String,
    @ColumnInfo(name = "short_descriptions") val shortDescriptions: String,

    )
