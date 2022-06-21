package com.example.yml.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [MovieDataBaseModel::class],
    exportSchema = false
)
//База данных
abstract class MovieDatabase : RoomDatabase() {
    abstract fun aboutMovieDao(): AboutMovieDao
}