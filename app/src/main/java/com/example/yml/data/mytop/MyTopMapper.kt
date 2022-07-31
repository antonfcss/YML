package com.example.yml.data.mytop

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.example.yml.data.db.MovieDataBaseModel
import com.example.yml.domain.popular.PopularFilmModel

class MyTopMapper {
    /*
    Принимаем обычную модель(не базы данных) MovieModel и возвращаем модель базы данных.
    Создаём и наполняем поля. Изменение модели осуществляем тут, к примеру если нужно поменять тип с
    Int на Long.
     */
    fun mapToDb(popularFilmModel: PopularFilmModel): MovieDataBaseModel {
        return MovieDataBaseModel(
            name = popularFilmModel.name,
            description = popularFilmModel.description,
            year = popularFilmModel.year,
            imdb = popularFilmModel.imdb,
            kp = popularFilmModel.kp,
            poster = popularFilmModel.poster.toString(),
            url = popularFilmModel.url,
            genre = popularFilmModel.genre,
            country = popularFilmModel.country,
            feesValue = popularFilmModel.feesValue
        )
    }

    fun mapToDomain(movieDataBaseModel: MovieDataBaseModel): PopularFilmModel {
        return PopularFilmModel(
            movieDataBaseModel.name,
            movieDataBaseModel.description,
            movieDataBaseModel.year,
            movieDataBaseModel.imdb,
            movieDataBaseModel.kp,
            stringToBitmap(movieDataBaseModel.poster),
            movieDataBaseModel.url,
            movieDataBaseModel.genre,
            movieDataBaseModel.country,
            movieDataBaseModel.feesValue
        )
    }

    private fun stringToBitmap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte =
                Base64.decode(encodedString, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.message
            null
        }
    }
}