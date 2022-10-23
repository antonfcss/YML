package com.example.yml.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yml.di.vm.DaggerViewModelFactory
import com.example.yml.di.vm.ViewModelKey
import com.example.yml.presentation.features.about.AboutMovieViewModel
import com.example.yml.presentation.features.login.LoginViewModel
import com.example.yml.presentation.features.mytop.MyTopViewModel
import com.example.yml.presentation.features.popular.PopularViewModel
import com.example.yml.presentation.features.search.SearchViewModel
import com.example.yml.presentation.features.signup.SignUpViewModel
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
    @ViewModelKey(PopularViewModel::class)
    abstract fun bindPopularViewModel(popularViewModel: PopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyTopViewModel::class)
    abstract fun bindMyTopViewModel(myTopViewModel: MyTopViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(signUpViewModel: SignUpViewModel): ViewModel

}