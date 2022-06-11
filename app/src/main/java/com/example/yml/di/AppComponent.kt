package com.example.yml.di

import com.example.yml.presentation.base.DaggerFragment
import com.example.yml.di.modules.AboutMovieModule
import com.example.yml.di.modules.ViewModelsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelsModule::class, AboutMovieModule::class])
interface AppComponent {
    fun inject(daggerFragment: DaggerFragment)
}