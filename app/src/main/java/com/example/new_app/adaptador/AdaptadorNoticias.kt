package com.example.new_app.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.databinding.ItemRowBinding
import com.example.new_app.model.Articulo
import com.squareup.picasso.Picasso

class AdaptadorNoticias : RecyclerView.Adapter<AdaptadorNoticias.CustomViewHolder>() {

    private var newlista : List<Articulo> = ArrayList()
    lateinit var listener: OnClickListenerRV

    class CustomViewHolder(itemView: View, var listener: OnClickListenerRV) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemRowBinding.bind(itemView)
        fun bindData(noticia:Articulo) {

            binding.tvTitulo.text = noticia.title
            binding.tvFecha.text = noticia.source.name
            binding.tvDescripcion.text = noticia.description
            Picasso.get()
                .load(noticia.urlToImage)
                .fit().centerCrop()
                .into(binding.ivImageArt)
            itemView.setOnClickListener{ listener.onClickItem(noticia)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(newlista[position])
    }

    override fun getItemCount(): Int {
        return newlista.size
    }

    fun setNoticia(noticias:List<Articulo>)
    {
        newlista = noticias as ArrayList<Articulo>
        notifyDataSetChanged()
    }

    interface OnClickListenerRV{
        fun onClickItem(noticia: Articulo)
    }

    fun setOnItemClickListener(listener: OnClickListenerRV)
    {
        this.listener = listener
    }

}