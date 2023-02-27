package com.example.newsapp.data.mappers

import com.example.newsapp.data.database.NewsEntity
import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.models.News
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    fun responseToEntity(response: NewsResponse) = with(response) {
        NewsEntity(
            author = author ?: "",
            title = title ?: "",
            description = description ?: "",
            link = link ?: "",
            imageUrl = imageUrl ?: "",
        )
    }

    fun entityToDefault(entity: NewsEntity) = with(entity) {
        News(
            author = author,
            title = title,
            description = description,
            link = link,
            imageUrl = imageUrl,
        )
    }
}