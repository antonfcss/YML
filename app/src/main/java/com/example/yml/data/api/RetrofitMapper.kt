package com.example.yml.data.api

import com.example.yml.domain.api.DomainRetrofitModel

//Маппер, который принимает RetrofitApiModule и возвращает DomainRetrofitModel
object RetrofitMapper {
    fun mapToDomain(testModule: DocsApi): DomainRetrofitModel{
        return DomainRetrofitModel(testModule.docs.first().logo.url)
    }
}
