package com.shubham.newsapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsItemModel")
data class NewsItemModel(
    val title: String
) {
    @PrimaryKey(autoGenerate = true)
    var newsId: Int = 0

}

