package com.example.yml

import android.app.Application
import com.example.yml.di.AppComponent
import com.example.yml.di.DaggerAppComponent
import com.example.yml.di.modules.AppModule

private var appComponentInitializer: AppComponent? = null
val appComponent: AppComponent
    get() = appComponentInitializer!!

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appComponentInitializer = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
