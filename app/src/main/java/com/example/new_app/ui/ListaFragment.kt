package com.example.new_app.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.new_app.R
import com.example.new_app.adaptador.AdaptadorNoticias
import com.example.new_app.databinding.ListaFragmentBinding
import com.example.new_app.model.Articulo
import com.example.new_app.viewmodel.ViewModel

class ListaFragment : Fragment() {

    private var b: ListaFragmentBinding? = null
    private val binding get() = b!!
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = ListaFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val adapter = AdaptadorNoticias()

          with(binding)
        {
            rvNoticias.layoutManager = LinearLayoutManager(context)
            rvNoticias.adapter = adapter
            viewModel.traeDataServer()
            adapter.setOnItemClickListener(object : AdaptadorNoticias.OnClickListenerRV {
                override fun onClickItem(noticia: Articulo) {


                    var miBundle = Bundle()
                    miBundle.putSerializable("noticia", noticia)

                    findNavController().navigate(R.id.action_listaFragment_to_articuloFragment, miBundle)
                }
           })
        }

        viewModel.traerNoticiasViewModel().observe(viewLifecycleOwner, Observer {

            Log.v("RecyclerViewNoticias", it.toString())
            adapter.setNoticia(it)

        })

           return binding.root

    }
}