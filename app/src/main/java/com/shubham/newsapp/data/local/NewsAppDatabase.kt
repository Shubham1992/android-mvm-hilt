package com.shubham.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shubham.newsapp.data.models.NewsItemModel

@Database(entities = [NewsItemModel::class], version = 1)
abstract class NewsAppDatabase : RoomDatabase() {

    abstract val newsItemDao: NewsItemDao
}