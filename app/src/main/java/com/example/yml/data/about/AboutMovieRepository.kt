package com.example.yml.data.about

import com.example.yml.domain.about.AboutMovieModel
import javax.inject.Inject

class AboutMovieRepository @Inject constructor(
    private val aboutMovieDataSource: AboutMovieDataSource,
    private val aboutMovieMapper: AboutMovieMapper
) {
    //Тут мы "ходим" в сеть за данными и превращаем их в сущность слоя domain
    fun getTestString(): AboutMovieModel {
        return aboutMovieMapper.mapToDomain(aboutMovieDataSource.getTestData())
    }
}