package com.shubham.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shubham.newsapp.data.models.NewsItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsItemDao {

    @Insert
    suspend fun insertNewsItem(user: NewsItemModel)

    @Query("SELECT * FROM NewsItemModel ORDER BY newsId DESC LIMIT 10")
    fun getNewsItem(): Flow<List<NewsItemModel>>
}