package com.example.newsapp.data.di

import android.content.Context
import com.example.newsapp.data.di.modules.DataBaseModule
import com.example.newsapp.data.di.modules.NetworkModule
import com.example.newsapp.data.di.modules.RepositoryModule
import com.example.newsapp.data.di.modules.ViewModelModule
import com.example.newsapp.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, DataBaseModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}