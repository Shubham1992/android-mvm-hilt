package com.shubham.newsapp.data.remote.api

import com.shubham.learnhilt.BuildConfig
import com.shubham.newsapp.data.models.ArticleResponse
import com.shubham.newsapp.data.models.NewsItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsItemAPI {

    @GET("everything")
    suspend fun getNewsItem(
        @Query("q") query: String,
        @Query("apiKey") apikey: String = BuildConfig.API_KEY,
        @Query("pageSize") pageSize: Int = 1
    ): Response<ArticleResponse>

}