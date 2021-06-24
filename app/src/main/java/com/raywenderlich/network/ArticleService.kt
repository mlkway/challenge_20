package com.raywenderlich.network

import com.raywenderlich.models.Articles
import com.raywenderlich.models.ArticlesItem
import retrofit2.Response
import retrofit2.http.GET

interface ArticleService {


    @GET("articles")
    suspend fun getArticles(): Response<List<ArticlesItem>>

}