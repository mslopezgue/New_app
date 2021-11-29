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

    private var lista : List<Articulo> = ArrayList()
    lateinit var onClickListener: OnClickListenerRV

    class CustomViewHolder(itemView: View, var onClickListener: OnClickListenerRV) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemRowBinding.bind(itemView)

        fun bindData(noticia:Articulo) {

            binding.tvTitulo.text = noticia.title
            binding.tvFecha.text = noticia.source.name
            binding.tvDescripcion.text = noticia.description


            Picasso.get().load(noticia.urlToImage).fit().centerCrop()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(binding.ivImageArt)

            itemView.setOnClickListener{
                onClickListener.alClickearItem(noticia)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return CustomViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setNoticia(noticias:List<Articulo>)
    {
        lista = noticias as ArrayList<Articulo>
        notifyDataSetChanged()
    }

    interface OnClickListenerRV{
        fun alClickearItem(noticia: Articulo)
    }

    fun setOnItemClickListener(onClickListener: OnClickListenerRV)
    {
        this.onClickListener = onClickListener
    }

}