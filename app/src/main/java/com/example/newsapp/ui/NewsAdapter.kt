package com.example.newsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.domain.models.News

class NewsAdapter(private val news: List<News>, private val itemCLick: (String) -> Unit) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(view, itemCLick)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }
}