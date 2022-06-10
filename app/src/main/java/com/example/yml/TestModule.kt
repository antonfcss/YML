package com.example.yml

import dagger.Module
import dagger.Provides

@Module
class TestModule {
    @Provides
    fun provideABC():ABC{
        return ABC("Тест Dagger 2")
    }
}