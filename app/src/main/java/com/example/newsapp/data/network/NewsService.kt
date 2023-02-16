package com.example.newsapp.data.network

import com.example.newsapp.data.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("everything")
    fun getNewsResponse(@Query("q") type: String): Call<List<NewsResponse>>
}