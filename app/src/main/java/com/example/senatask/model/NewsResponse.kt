package com.example.senatask.model

data class NewsResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String

)