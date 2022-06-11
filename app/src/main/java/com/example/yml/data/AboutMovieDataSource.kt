package com.example.yml.data

class AboutMovieDataSource {
    //Представляем что это запрос в сеть
    fun getTestData(): AboutMovieDataModel {
        return AboutMovieDataModel("Тест Dagger2")
    }
}