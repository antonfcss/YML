package com.example.yml.di.modules

import com.example.yml.data.about.AboutMovieDataSource
import com.example.yml.data.about.AboutMovieMapper
import dagger.Module
import dagger.Provides

@Module
class AboutMovieModule {

    @Provides
    fun provideAboutMovieMapper(): AboutMovieMapper {
        return AboutMovieMapper()
    }

    @Provides
    fun provideAboutMovieDataSource(): AboutMovieDataSource {
        return AboutMovieDataSource()
    }
}