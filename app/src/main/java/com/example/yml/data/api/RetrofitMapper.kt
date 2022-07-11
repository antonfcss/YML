package com.example.yml.data.api

import android.graphics.Bitmap
import com.example.yml.domain.api.DomainRetrofitModel
import com.squareup.picasso.Picasso

//Маппер, который принимает RetrofitApiModule и возвращает DomainRetrofitModel
object RetrofitMapper {
    fun mapToDomain(testModule: DocsApi): DomainRetrofitModel{
        return DomainRetrofitModel(testModule.docs.first().logo.url, getImageFromRemote(testModule.docs.first().))
    }

    private fun getImageFromRemote(url: String): Bitmap?{
       return Picasso.get().load(url).get()
    }
}
