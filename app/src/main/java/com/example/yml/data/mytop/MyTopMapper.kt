package com.example.yml.data.mytop

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.example.yml.data.db.MovieDataBaseModel
import com.example.yml.domain.popular.PopularFilmModel
import java.io.ByteArrayOutputStream

class MyTopMapper {

    fun mapToDb(popularFilmModel: PopularFilmModel): MovieDataBaseModel {
        return MovieDataBaseModel(
            name = popularFilmModel.name,
            description = popularFilmModel.description,
            year = popularFilmModel.year,
            imdb = popularFilmModel.imdb,
            kp = popularFilmModel.kp,
            poster = bitmapToString(popularFilmModel.poster!!)!!,
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

    private fun bitmapToString(bitmap: Bitmap): String? {
        val byteArray = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray)
        val b: ByteArray = byteArray.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    private fun stringToBitmap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte = Base64.decode(encodedString, Base64.DEFAULT)
            val bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
            bitmap
        } catch (e: java.lang.Exception) {
            e.message
            null
        }
    }
}