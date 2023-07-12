package com.shubham.newsapp.data.repositories

import android.database.sqlite.SQLiteDatabase
import androidx.room.Room
import com.shubham.newsapp.data.local.NewsAppDatabase
import com.shubham.newsapp.data.local.NewsItemDao
import com.shubham.newsapp.data.models.NewsItemModel
import com.shubham.newsapp.data.remote.RetrofitClient
import com.shubham.newsapp.data.remote.api.NewsItemAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsItemRepository @Inject constructor(private val database: NewsAppDatabase) :
    INewsItemRepository {
    private lateinit var newsApi: NewsItemAPI


    override
    suspend fun getNewsItem(): NewsItemModel? {
        newsApi = RetrofitClient.getInstance().create(NewsItemAPI::class.java)
        val data = newsApi.getNewsItem("bitcoin")?.let {
            return@let it.body()
        }

        data?.let { response ->
            response.articles?.let { articles ->
                database.newsItemDao.insertNewsItem(articles[0])
            }
        }

        return data?.articles?.get(0)
    }

}