package com.example.newsapp.data.mappers

import com.example.newsapp.data.database.NewsEntity
import com.example.newsapp.data.models.NewsResponse
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    operator fun invoke(response: NewsResponse) = with(response) {
        NewsEntity(
            author = author ?: "",
            title = title ?: "",
            description = description ?: "",
            link = link ?: "",
            imageUrl = imageUrl ?: "",
        )
    }
}