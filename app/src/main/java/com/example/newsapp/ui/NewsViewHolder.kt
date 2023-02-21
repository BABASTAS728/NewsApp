package com.example.newsapp.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.domain.models.News

class NewsViewHolder(itemView: View, private val itemClick: (String) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(news: News) {
        itemView.findViewById<TextView>(R.id.author).text = news.author
        itemView.findViewById<TextView>(R.id.title).text = news.title
        itemView.findViewById<TextView>(R.id.description).text = news.description
        Glide.with(itemView.context)
            .load(news.imageUrl)
            .into(itemView.findViewById(R.id.image))

        itemView.setOnClickListener {
            itemClick.invoke(news.link)
        }
    }
}