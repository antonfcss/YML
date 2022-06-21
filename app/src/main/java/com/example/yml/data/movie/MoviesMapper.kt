package com.example.yml.data.movie

import com.example.yml.data.db.MovieDataBaseModel
import com.example.yml.domain.movie.MovieModel

//Преобразование классов с одним  типом данных в класс с другим типом данных.
class MoviesMapper {
    /*
    Принимаем обычную модель(не базы данных) MovieModel и возвращаем модель базы данных.
    Создаём и наполняем поля. Изменение модели осуществляем тут, к примеру если нужно поменять тип с
    Int на Long.
     */
    fun mapToDb(movieModel: MovieModel): MovieDataBaseModel {
        return MovieDataBaseModel(
            movieModel.id,
            movieModel.posterMovie,
            movieModel.title,
            movieModel.ratingKp,
            movieModel.ratingImdb,
            movieModel.releaseDate,
            movieModel.movieCountry,
            movieModel.movieGenre,
            movieModel.grossWorldwide,
            movieModel.shortDescriptions
        )
    }
    fun mapToDomain(movieDataBaseModel: MovieDataBaseModel): MovieModel{
        return MovieModel(
            movieDataBaseModel.id,
            movieDataBaseModel.posterMovie,
            movieDataBaseModel.title,
            movieDataBaseModel.ratingKp,
            movieDataBaseModel.ratingImdb,
            movieDataBaseModel.releaseDate,
            movieDataBaseModel.movieCountry,
            movieDataBaseModel.movieGenre,
            movieDataBaseModel.grossWorldwide,
            movieDataBaseModel.shortDescriptions
        )
    }
}