package com.example.yml.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.yml.data.db.AboutMovieDao
import com.example.yml.data.db.MovieDatabase
import dagger.Provides
import javax.inject.Singleton


class DataModule(private val application: Application) {

    @Singleton
    @Provides
    fun getMovieDao(movieDatabase: MovieDatabase): AboutMovieDao {
        return movieDatabase.aboutMovieDao()
    }

    @Singleton
    @Provides
    fun getRoomInstance(): MovieDatabase {
        return MovieDatabase.init(provideAppContext())
    }

    @Singleton
    @Provides
    private fun provideAppContext(): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun getDataBase(): MovieDatabase {
        return Room.databaseBuilder(application, MovieDatabase::class.java, "database").build()
    }
}