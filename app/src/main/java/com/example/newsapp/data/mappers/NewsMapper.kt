package com.example.newsapp.data.mappers

import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.models.News
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    operator fun invoke(response: NewsResponse) = with(response) {
        News(
            author = author ?: "",
            title = title ?: "",
            description = description ?: "",
            link = link ?: "",
            imageUrl = imageUrl ?: "",
        )
    }
}