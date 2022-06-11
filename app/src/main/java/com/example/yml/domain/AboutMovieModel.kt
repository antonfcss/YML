package com.example.yml.domain

//Модель готовая для отображения, но в Domain слое мы не храним Android зависимости, т.е. если в модели есть Android зависимость
//То тогда мы делаем еще один маппер и модель в presentation слое
data class AboutMovieModel(val testString: String)