package com.example.yml.data.api

import com.example.yml.domain.api.DomainRetrofitModel

//Маппер, который принимает RetrofitApiModule и возвращает DomainRetrofitModel
object RetrofitMapper {
    fun mapToDomain(testModule: TestApi): DomainRetrofitModel{
        return DomainRetrofitModel(testModule.url)
    }
}