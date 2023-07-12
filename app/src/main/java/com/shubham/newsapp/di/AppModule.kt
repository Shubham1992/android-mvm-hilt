package com.shubham.newsapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shubham.newsapp.data.local.NewsAppDatabase
import com.shubham.newsapp.data.repositories.NewsItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsAppDatabase(app: Application): NewsAppDatabase {
        return Room.databaseBuilder(app, NewsAppDatabase::class.java, "newsapp_database").build()
    }

    @Provides
    @Singleton
    fun provideNewsItemRepository(database: NewsAppDatabase): NewsItemRepository {
        return NewsItemRepository(database)
    }
}