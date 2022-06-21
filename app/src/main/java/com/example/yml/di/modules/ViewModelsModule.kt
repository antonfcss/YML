package com.example.yml.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yml.presentation.features.about.AboutMovieViewModel
import com.example.yml.di.vm.DaggerViewModelFactory
import com.example.yml.di.vm.ViewModelKey
import com.example.yml.presentation.features.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton
//Хранение ViewModel. Сдесь мы указываем всё ViewModel, когда создаём новые экраны
@Module
abstract class ViewModelsModule {
    @Binds
    @Singleton
    abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AboutMovieViewModel::class)
    abstract fun bindMenuViewModel(menuTestsViewModel: AboutMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindMovieViewModel(MovieViewModel: MovieViewModel): ViewModel
}