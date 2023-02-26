package com.example.senatask.myviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.senatask.api.NewsApi
import com.example.senatask.paging.NewsPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor (val newsApi: NewsApi ):ViewModel()
{

    val list= Pager(PagingConfig(pageSize = 10)){
        NewsPaging(newsApi)
    }.flow.cachedIn(viewModelScope)

}