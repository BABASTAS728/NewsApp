package com.example.newsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.database.NewsEntity
import com.example.newsapp.databinding.NewsLayoutBinding

class NewsAdapter(private val itemCLick: (String) -> Unit) :
    RecyclerView.Adapter<NewsViewHolder>() {

    private val news = mutableListOf<NewsEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsLayoutBinding = NewsLayoutBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(newsLayoutBinding, itemCLick)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

    fun setNews(news: List<NewsEntity>) {
        this.news.clear()
        this.news.addAll(news)
        notifyDataSetChanged()
    }
}