package com.example.senatask.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.senatask.api.NewsApi
import com.example.senatask.utils.Constants
import com.example.senatask.model.Result

class NewsPaging (val newsApi: NewsApi) : PagingSource<Int, Result>(){
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {

        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page=params.key?:1

        return try {

            val apikey:String=Constants.API_KEY
            val data=newsApi.getNews(apikey)
          //  Log.e("bnews",data.body().toString())
            LoadResult.Page(
                data= data.body()?.results!!,
                prevKey = if(page==1) null else page-1,
                nextKey = if (data.body()?.results?.isEmpty()!!) null else page+1
            )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }

    }

}