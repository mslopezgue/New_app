package com.example.new_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.new_app.model.Articulo
import androidx.lifecycle.ViewModel
import com.example.new_app.repositorio.RepositorioNoticias

class ViewModel:  ViewModel() {
    private var repositorio = RepositorioNoticias()

    fun traeDataServer() {
        Log.v("expone traeDataServer", repositorio.traerDataRepo().toString())
        repositorio.traerDataRepo()

    }

    fun traerNoticiasViewModel(): MutableLiveData<List<Articulo>> {

        Log.v("expone traerNoticiasViewModel", repositorio.mostrarDataRepo().value.toString())
        return repositorio.mostrarDataRepo()

    }

    fun buscarNoticiasenViewModel (noticia:String, idioma: String, apikey:String) {
        Log.v("expone buscarNoticiasenViewModel", repositorio.buscarNoticiasEnRepo(noticia, idioma,apikey).toString())
        return repositorio.buscarNoticiasEnRepo(noticia, idioma,apikey)
    }

    fun MostrarBusquedaViewModel(): MutableLiveData<List<Articulo>> {
        Log.v("expone MostrarBusquedaViewModel", repositorio.exponeBusquedaDeNoticias_EnRepo().value.toString())
        return repositorio.mostrarDataRepo()
    }

}
