package com.example.newsapp.data

import com.example.newsapp.data.database.NewsEntity
import com.example.newsapp.data.mappers.NewsMapper
import com.example.newsapp.data.network.NewsService
import com.example.newsapp.data.source.DataBaseSource
import com.example.newsapp.data.source.UserDataSource
import com.example.newsapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: NewsService,
    private val newsMapper: NewsMapper,
    private val userDataSource: UserDataSource,
    private val dataBaseSource: DataBaseSource
) : Repository {

    override suspend fun getNewsList(connection: Boolean): List<NewsEntity> {
        return withContext(Dispatchers.IO) {
            if (connection) {
                val response =
                    service.getNewsResponse("apple", userDataSource.getUserToken()).execute().body()
                        ?: throw Exception()
                val newsList = (response.list ?: listOf()).map { newsMapper(it) }
                dataBaseSource.delete(dataBaseSource.getAll())
                dataBaseSource.insertAll(newsList)
                newsList
            } else dataBaseSource.getAll()
        }
    }

    override fun setToken(token: String) {
        userDataSource.setUserToken(token)
    }
}