package com.example.yml.di.modules

import com.example.yml.data.movie.MoviesMapper
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @Provides
    fun provideMoviesMapper()=MoviesMapper()
}