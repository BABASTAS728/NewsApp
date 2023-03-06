package com.example.newsapp

import android.app.Application
import com.example.newsapp.data.di.ApplicationComponent
import com.example.newsapp.data.di.DaggerApplicationComponent

class NewsApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}