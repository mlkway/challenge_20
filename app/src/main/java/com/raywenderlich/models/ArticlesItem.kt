package com.raywenderlich.models


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class ArticlesItem(
    @Json(name = "events")
    val events: List<String>,
    @Json(name = "featured")
    val featured: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "launches")
    val launches: List<Any>,
    @Json(name = "newsSite")
    val newsSite: String,
    @Json(name = "publishedAt")
    val publishedAt: String,
    @Json(name = "summary")
    val summary: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "updatedAt")
    val updatedAt: String,
    @Json(name = "url")
    val url: String
)