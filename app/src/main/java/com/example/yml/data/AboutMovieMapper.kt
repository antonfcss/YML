package com.example.yml.data

import com.example.yml.domain.AboutMovieModel

class AboutMovieMapper {
    //Преобразует модель из сети в модель для domain
    fun mapToDomain(aboutMovieDataModel: AboutMovieDataModel): AboutMovieModel{
        return AboutMovieModel(aboutMovieDataModel.testString)
    }
}