package com.example.senatask.api

import com.example.senatask.model.NewsResponse
import com.example.senatask.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("viewed/1.json")
    suspend fun getNews(
        @Query("api-key") apikey :String= Constants.API_KEY
    ): Response<NewsResponse>



}