package com.example.yml.data.about

class AboutMovieDataSource {
    //Представляем что это запрос в сеть
    fun getTestData(): AboutMovieDataModel {
        return AboutMovieDataModel("Тест Dagger2")
    }
}