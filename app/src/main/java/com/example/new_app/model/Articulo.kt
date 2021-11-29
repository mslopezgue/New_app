package com.example.new_app.model

import java.io.Serializable

data class Articulo(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
    )
    : Serializable