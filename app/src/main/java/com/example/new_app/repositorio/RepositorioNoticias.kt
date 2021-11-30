package com.example.new_app.repositorio


import com.example.new_app.adaptador.database.NoticiasDataBase
import com.example.new_app.cliente.ClienteNoticias
import com.example.new_app.dao.DaoNews
import com.example.new_app.dao.DaoNews_Impl
import com.example.new_app.model.Articulo
import com.example.new_app.servicio.APIService

class RepositorioNoticias (private val api: APIService, private val dao: DaoNews)
{
        suspend fun noticiasHome()= api.noticiasHome()
        suspend fun upsert(mutableListOf<NewsEntity>()) = db.getArticleDao().upsert(articulo)


        suspend fun searchNews(query: String, page: Int) = api.buscarNoticias(query, page)

        suspend fun upsert(articulo: Articulo) = db.getData().upsert(article)


    }