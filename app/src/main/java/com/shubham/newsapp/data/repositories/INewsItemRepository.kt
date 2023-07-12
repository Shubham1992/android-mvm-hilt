package com.shubham.newsapp.data.repositories

import com.shubham.newsapp.data.models.NewsItemModel

interface INewsItemRepository {

    suspend fun getNewsItem(): NewsItemModel?
}