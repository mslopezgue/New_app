package com.example.new_app.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.new_app.R
import com.example.new_app.adaptador.AdaptadorNoticias
import com.example.new_app.databinding.BuscarFragmentBinding
import com.example.new_app.model.Articulo
import com.example.new_app.viewmodel.ViewModel

class BuscarFragment : Fragment() {

    private var b: BuscarFragmentBinding? = null
    private val binding get() = b!!
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b =BuscarFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val adapter = AdaptadorNoticias()
        with(binding)
        {
            rvNoticias.layoutManager = LinearLayoutManager(context)
            rvNoticias.adapter = adapter
            viewModel.buscarNoticiasenViewModel("Chile", "es","6d648fd5802448b09fe8a59863c5efc1")

            adapter.setOnItemClickListener(object : AdaptadorNoticias.OnClickListenerRV {

                override fun alClickearItem(noticia: Articulo) {
                    //Lo que quiero al hacer click al recicler en el fragmemnt buscar

                    var miBundleEnBuscar = Bundle()
                    miBundleEnBuscar.putSerializable("noticia", noticia)

                    findNavController().navigate(
                        R.id.action_buscarFragment_to_articuloFragment,
                        miBundleEnBuscar
                    )
                }
            })
        }

        binding.searchNoticia.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query!!.isNotEmpty()) {
                    Log.v("buscarNoticia", "La query no esta vacia")
                    viewModel.buscarNoticiasenViewModel(query, "es","6d648fd5802448b09fe8a59863c5efc1")
                } else {
                    Toast.makeText(
                        context,
                        "Debes completar el campo de busqueda antes de realizarla",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        viewModel.MostrarBusquedaViewModel().observe(viewLifecycleOwner, Observer {

            try {
                adapter.setNoticia(it)
            } catch (ex: Exception) {
                Log.e("ErrorBusqueda", ex.message.toString())
                Toast.makeText(context, "No hay resultados para tú busqueda", Toast.LENGTH_SHORT)
                    .show()
            }

        })

        return binding.root
    }
}
