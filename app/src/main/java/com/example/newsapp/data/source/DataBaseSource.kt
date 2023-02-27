package com.example.newsapp.data.source

import com.example.newsapp.data.database.NewsDao
import com.example.newsapp.data.database.NewsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DataBaseSource @Inject constructor(
    private val dao: NewsDao
) {
    suspend fun getAll() = withContext(Dispatchers.IO) { dao.getAll() }

    suspend fun insertAll(news: List<NewsEntity>) =
        withContext(Dispatchers.IO) { dao.insertAll(news) }

    suspend fun delete(news: List<NewsEntity>) = withContext(Dispatchers.IO) { dao.delete(news) }
}