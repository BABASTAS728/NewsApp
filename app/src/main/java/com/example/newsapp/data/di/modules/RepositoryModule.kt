package com.example.newsapp.data.di.modules

import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun getRepository(impl: RepositoryImpl): Repository
}