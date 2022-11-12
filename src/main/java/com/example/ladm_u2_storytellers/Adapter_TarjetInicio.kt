package com.example.ladm_u2_storytellers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class Adapter_TarjetInicio(private val destacado: List<String>, private val onItemClickListener: onItemClick) : RecyclerView.Adapter<Adapter_TarjetInicio.ViewHolder>(){

    interface onItemClick{
        fun verClick(position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.tarjeta_inicio, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return destacado.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemButton.text = "Ver"
    }

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        lateinit var itemButton: Button

        init{
            var btnVerContenido: Button = itemview.findViewById(R.id.tarjetaInicio_btnVer)
            btnVerContenido.setOnClickListener {
                onItemClickListener.verClick(1)
            }
        }
    }
}