package com.example.yml.di

import com.example.yml.di.modules.*
import com.example.yml.presentation.base.DaggerFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ViewModelsModule::class,
        AboutMovieModule::class, DataModule::class, MovieModule::class, NetworkModule::class]
)
interface AppComponent {
    fun inject(daggerFragment: DaggerFragment)
}