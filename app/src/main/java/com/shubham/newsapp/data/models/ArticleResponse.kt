package com.shubham.newsapp.data.models

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsItemModel>
)