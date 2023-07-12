package com.shubham.newsapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.newsapp.data.repositories.NewsItemRepository
import com.shubham.newsapp.ui.NewsItemUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private  val  repository: NewsItemRepository) : ViewModel() {


    private val newsDataInternal = MutableLiveData<NewsItemUIState>()
    val newsData: LiveData<NewsItemUIState>
        get() = newsDataInternal


    fun getNewsItem() {
        viewModelScope.launch {
            val data = repository.getNewsItem()
            data?.let {
                val uiStateData = NewsItemUIState(title = it.title )
                newsDataInternal.postValue(uiStateData)


            }

        }
    }

}