package com.example.new_app.cliente

import android.app.Application
import com.example.new_app.servicio.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteNoticias: Application() {

    companion object {

         val URL_BASE = "https://newsapi.org/v2/"

        fun getCliente(): APIService {
            val retrofit = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            return retrofit.create(APIService::class.java)
        }
    }
}