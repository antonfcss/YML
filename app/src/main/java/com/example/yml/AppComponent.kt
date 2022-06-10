package com.example.yml

import dagger.Component

@Component(modules = [TestModule::class])
interface AppComponent {
    fun ABC(): ABC
    fun inject(aboutMovieFragment: AboutMovieFragment) {}
}