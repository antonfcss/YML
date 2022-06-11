package com.example.yml

import android.app.Application
import android.content.Context
import com.example.yml.di.AppComponent
import com.example.yml.di.DaggerAppComponent

class MainApp: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when(this){
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }