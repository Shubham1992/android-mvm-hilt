package com.shubham.newsapp.data.remote.api

import com.shubham.newsapp.data.models.NewsItemModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface UserAPI {

    @GET("/user")
    suspend fun getUser(): Flow<NewsItemModel>

}