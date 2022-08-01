package com.example.yml.di.modules

import com.example.yml.data.popular.PopularApi
import com.example.yml.data.search.SearchApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.kinopoisk.dev/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): PopularApi = retrofit.create()

    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create()

}