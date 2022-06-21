package com.example.yml.data.about

import com.example.yml.domain.about.AboutMovieModel

class AboutMovieMapper {
    //Преобразует модель из сети в модель для domain
    fun mapToDomain(aboutMovieDataModel: AboutMovieDataModel): AboutMovieModel {
        return AboutMovieModel(aboutMovieDataModel.testString)
    }
}