package com.example.newsapp.data.di.modules

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.database.NewsDao
import com.example.newsapp.data.database.NewsDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase( context: Context): NewsDataBase {
        return Room.databaseBuilder(context, NewsDataBase::class.java, "news_table")
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: NewsDataBase): NewsDao = db.getNewsDao()
}