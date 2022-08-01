package com.example.yml.di.modules

import com.example.yml.data.mytop.MyTopMapper
import dagger.Module
import dagger.Provides

@Module
class MyTopModule {
    @Provides
    fun provideMyTopMapper() = MyTopMapper()
}