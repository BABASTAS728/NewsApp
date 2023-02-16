package com.example.newsapp.domain

import com.example.newsapp.domain.models.News

interface Repository {
    suspend fun getNewsList(): List<News>
}