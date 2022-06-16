package com.example.yml.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [Movie::class]
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun aboutMovieDao(): AboutMovieDao

    companion object {
        lateinit var instance: MovieDatabase

        fun init(applicationContext: Context): MovieDatabase {
            instance = Room
                .databaseBuilder(applicationContext, MovieDatabase::class.java, "db")

                // чтобы база была в одном файлике (без  Write-Ahead-Log)
                .setJournalMode(JournalMode.TRUNCATE)

                .build()
            return instance
        }
    }
}