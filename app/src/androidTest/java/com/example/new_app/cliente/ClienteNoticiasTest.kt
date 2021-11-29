package com.example.new_app.cliente

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.new_app.FileReader
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test


import org.junit.runner.RunWith
import com.google.common.truth.Truth

@RunWith(AndroidJUnit4::class)
class ClienteNoticiasTest {

        private var server = MockWebServer()
        private val body = FileReader.lectorJson("noticias.json")
    @Before
    fun setUp() {
        server.start(8080)
        server.enqueue(MockResponse().setResponseCode(200).setBody(body))
        server.url("test/top-headlines?country=mx&apiKey=e15d263b39584d48867ee430d7a1ab93")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun test_apiExitosa() {
        val call = ClienteNoticias.getCliente("http://localhost:8080/test/").noticiasHome()
        var noticia = call.execute().body()
        Truth.assertThat(noticia!!.articles[0].description.toString())
            .isEqualTo("Tigres vs Santos Liga MX EN VIVO: Cuartos de Final Vuelta - Diario Deportivo Record")
    }
}
