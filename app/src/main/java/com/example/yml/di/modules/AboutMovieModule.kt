package com.example.yml.di.modules

import com.example.yml.data.AboutMovieDataSource
import com.example.yml.data.AboutMovieMapper
import dagger.Module
import dagger.Provides

@Module
class AboutMovieModule {
    //Если у класса есть @Inject constructor, то в модуль его добавлять не нужно
    //Если нет, то использовать аннотацию Provides
    @Provides
    fun provideAboutMovieMapper(): AboutMovieMapper {
        return AboutMovieMapper()
    }
    @Provides
    fun provideAboutMovieDataSource(): AboutMovieDataSource {
        return AboutMovieDataSource()
    }
}