package com.example.dmsapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dmsapp.R
import com.example.dmsapp.model.Auto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_auto.view.*

class AdapterAutos () : RecyclerView.Adapter<AdapterAutos.ViewHolder>() {

    lateinit var items: ArrayList<Auto>

    fun setAutos(items: List<Auto>){
        this.items = items as ArrayList<Auto>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val autoImg: ImageView = view.auto_img
        val nombre: TextView = view.nombre
        val descripcion: TextView = view.descripcion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_auto, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.nombre.text = model.nombre
        holder.descripcion.text = model.descripcion
        Picasso.get()
            .load(model.img)
            .into(holder.autoImg)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}