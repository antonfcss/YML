package com.example.yml

import android.app.Application
import android.content.Context
import com.example.yml.data.db.MovieDatabase
import com.example.yml.di.AppComponent
import com.example.yml.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        MovieDatabase.init(this )
    }
}

val Context.appComponent: AppComponent
    get() = when(this){
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }