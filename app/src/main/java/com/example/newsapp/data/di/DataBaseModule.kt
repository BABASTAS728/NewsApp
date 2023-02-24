package com.example.newsapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.database.NewsDao
import com.example.newsapp.data.database.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): NewsDataBase {
        return Room.databaseBuilder(context, NewsDataBase::class.java, "news_table")
            .build()
    }

    @Provides
    fun provideUserDao(db: NewsDataBase): NewsDao = db.getNewsDao()
}