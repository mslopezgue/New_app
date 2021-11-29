package com.example.new_app.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.new_app.R
import com.example.new_app.databinding.ArticuloFragmentBinding
import com.example.new_app.model.Articulo
import com.example.new_app.viewmodel.ViewModel
import com.squareup.picasso.Picasso

class ArticuloFragment : Fragment() {

    private var b: ArticuloFragmentBinding? = null
    private val binding get() = b!!
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = ArticuloFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        var noticia = arguments?.getSerializable("noticia") as Articulo



        with(binding) {
            tvAutor.text = noticia.author
            tvFechaPublicaiN.text = noticia.publishedAt
            tvFuente.text = noticia.source.name
            tvTituloDetalle.text = noticia.title
            tvNoticia.text = noticia.description

            Picasso.get().load(noticia.urlToImage).fit().centerCrop()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(binding.ivImagenDetalle)
        }



        binding.ivImagenDetalle.setOnClickListener(View.OnClickListener {
            val webIntent: Intent = Uri.parse("${noticia.url}").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)

            }

            startActivity(webIntent)


        })


        binding.btnCompartir.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Chequea esta noticia"+"\n ${noticia.url}")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Compartir"))

        }

        return binding.root
    }

    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(activity?.packageManager!!) == null) {
            startActivity(intent)
        }
    }
}