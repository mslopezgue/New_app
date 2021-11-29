package com.example.new_app.model

data class NoticiaResponse (

val articles: List<Articulo>,
val status: String,
val totalResults: Int
)