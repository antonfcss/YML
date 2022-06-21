package com.example.yml.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    //Модуль для получения Application
    @Provides
    @Singleton
    fun providesApplication(): Application = application
    //Модуль для получения Context
    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application
}