package com.example.yml.di.modules

import com.example.yml.data.popular.PopularApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule() {

    //Провайдем OkHttp
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        //Создаём OkHttp
        return OkHttpClient.Builder().build()
    }

    //Создаём Retrofit
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.kinopoisk.dev/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    //Провайдем Api. С помощью данной функции мы соеденяем наши запросы
    // из RetrofitApi и соединяем их с Retrofit
    @Provides
    fun provideApi(retrofit: Retrofit): PopularApi = retrofit.create()


}