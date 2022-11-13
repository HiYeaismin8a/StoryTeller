package mx.edu.ittepic.storyteller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_TarjetInicio(private val destacado: Array<String>,
                           private val libros_nombre: Array<String>,
                           private val libros_descripcion: Array<String>,
                           private val libros_tags: Array<String>,
                           private val onItemClickListener: onItemClick) : RecyclerView.Adapter<Adapter_TarjetInicio.ViewHolder>(){

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
        viewHolder.itemNombre.text = libros_nombre[i]
        viewHolder.itemDescripcion.text = libros_descripcion[i]
        viewHolder.itemTags.text = libros_tags[i]
    }

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        var itemNombre: TextView
        var itemDescripcion: TextView
        var itemTags: TextView

        init{
            var btnVerContenido: Button = itemview.findViewById(R.id.tarjetaInicio_btnVer)
            btnVerContenido.setOnClickListener {
                onItemClickListener.verClick(1)
            }

            itemNombre = itemView.findViewById(R.id.tarjetaInicio_Nombre)
            itemDescripcion = itemView.findViewById(R.id.tarjetaInicio_Descripcion)
            itemTags = itemView.findViewById(R.id.tarjetaInicio_Tags)
        }
    }
}