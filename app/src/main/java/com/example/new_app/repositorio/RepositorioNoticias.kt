package com.example.new_app.repositorio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.new_app.cliente.ClienteNoticias
import com.example.new_app.model.Articulo
import com.example.new_app.model.NoticiaResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositorioNoticias {

    private var cliente = ClienteNoticias.getCliente()
    var lista = MutableLiveData<List<Articulo>>()

    fun traerDataRepo() {

        val call = cliente.noticiasHome()
        call.enqueue(object : Callback<NoticiaResponse> {

            override fun onResponse(call: Call<NoticiaResponse>, response: Response<NoticiaResponse>) {
                CoroutineScope(Dispatchers.IO).launch {
                    lista.postValue(response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<NoticiaResponse>, t: Throwable) {
                call.cancel()
            }
        })

    }

    fun mostrarDataRepo(): MutableLiveData<List<Articulo>> {
        Log.v("mostrarDataRepo", lista.toString())
        return lista
    }


    fun buscarNoticiasEnRepo(noticia: String, idioma: String, apikey: String) {

        val call = cliente.buscarNoticias(noticia, idioma, apikey)
        call.enqueue(object : Callback<NoticiaResponse> {
            override fun onResponse(call: Call<NoticiaResponse>, response: Response<NoticiaResponse>) {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.v("buscarNoticiasEnRepo", lista.value.toString())
                    lista.postValue(response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<NoticiaResponse>, t: Throwable) {
                call.cancel()

            }
        })

    }

    fun exponeBusquedaDeNoticias_EnRepo(): MutableLiveData<List<Articulo>> {
        Log.v("exponeBusquedaNoticias_EnRepo", lista.toString())
        return lista
    }
}