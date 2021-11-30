package com.example.new_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.new_app.model.Articulo
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.new_app.repositorio.RepositorioNoticias

class ViewModel  (

    val newsRepository: RepositorioNoticias
    ) : ViewModel() {

        val homeNews: MutableLiveData<Resource<NoticiAResponse>> = MutableLiveData()
        var breakingNewsPage = 1

        val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
        var searchNewsPage = 1

        init {
          homeNews("mx")private var repositorio = RepositorioNoticias()

