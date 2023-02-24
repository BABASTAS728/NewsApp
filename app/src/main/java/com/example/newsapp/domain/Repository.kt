package com.example.newsapp.domain

import com.example.newsapp.data.database.NewsEntity

interface Repository {
    suspend fun getNewsList(connection: Boolean): List<NewsEntity>
    fun setToken(token: String)
}