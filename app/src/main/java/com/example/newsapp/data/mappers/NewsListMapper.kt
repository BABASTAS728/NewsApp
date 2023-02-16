package com.example.newsapp.data.mappers

import com.example.newsapp.data.models.NewsListResponse
import com.example.newsapp.domain.models.NewsList
import javax.inject.Inject

class NewsListMapper @Inject constructor() {
    operator fun invoke(response: NewsListResponse) = NewsList(
        list = response.list ?: listOf()
    )
}