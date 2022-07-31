package com.example.yml.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Модель данных
@Entity(tableName = "movies")
data class MovieDataBaseModel(
    @PrimaryKey @ColumnInfo(name = "name_movie") val name: String,
    @ColumnInfo(name = "description_movie") val description: String,
    @ColumnInfo(name = "release_date") val year: Int,
    @ColumnInfo(name = "rating_imdb") val imdb: String,
    @ColumnInfo(name = "rating_kp") val kp: String,
    @ColumnInfo(name = "poster_movie") val poster: String,
    @ColumnInfo(name = "url_trailer") val url: String?,
    @ColumnInfo(name = "movie_genre") val genre: String,
    @ColumnInfo(name = "movie_country") val country: String,
    @ColumnInfo(name = "gross_worldwide") val feesValue: Long,
)
