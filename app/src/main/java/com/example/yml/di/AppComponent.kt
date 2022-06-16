package com.example.yml.di

import com.example.yml.di.modules.AboutMovieModule
import com.example.yml.di.modules.DataModule
import com.example.yml.di.modules.ViewModelsModule
import com.example.yml.presentation.base.DaggerFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelsModule::class, AboutMovieModule::class, DataModule::class])
interface AppComponent {
    fun inject(daggerFragment: DaggerFragment)
    fun inject()
}