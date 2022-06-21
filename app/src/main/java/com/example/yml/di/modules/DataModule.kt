package com.example.yml.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yml.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule() {
//Функция создания Room для работы с Dagger
    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movieDB")
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }
}