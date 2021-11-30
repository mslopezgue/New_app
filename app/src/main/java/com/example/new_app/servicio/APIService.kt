package com.example.new_app.servicio

import com.example.new_app.model.NoticiaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    fun noticiasHome(
        @Query("country", encoded = true)
        pais: String = "mx",
        @Query("page",encoded = true)
        pag: Int = 1,
        @Query("apiKey", encoded = true)
        apiKey: String = "e15d263b39584d48867ee430d7a1ab93"
    ): Response<NoticiaResponse>


    @GET("everything")
    fun buscarNoticias(
        @Query(value = "q", encoded = true)
        query: String,
        @Query("page",encoded = true)
        pag: Int = 1,
        @Query(value = "language", encoded = true)
        idioma: String,
        @Query("apiKey",encoded = true)
        apiKey: String = "e15d263b39584d48867ee430d7a1ab93"
    ): Response<NoticiaResponse>

    }