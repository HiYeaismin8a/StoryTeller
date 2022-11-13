package mx.edu.ittepic.storyteller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_TarjetaNosotros(private val estudiantes: Array<String>, private val noControl:
Array<String>, private val imagenes: Array<Int>, val onItemClickListener: onItemClick) : RecyclerView.Adapter<Adapter_TarjetaNosotros.ViewHolder>() {

    interface onItemClick{
        fun verClick(position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.tarjeta_nosotros, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return estudiantes.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemNombre.text = estudiantes[i]
        viewHolder.itemNoCtrl.text = noControl[i]
        viewHolder.itemCarrera.text = "ISC"
        viewHolder.itemFoto.setImageResource(imagenes[i])
    }

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        var itemNombre: TextView
        var itemNoCtrl: TextView
        var itemCarrera: TextView
        var itemFoto: ImageView

        init{
            itemNombre = itemView.findViewById(R.id.tarjetaNosotrs_Nombre)
            itemNoCtrl = itemView.findViewById(R.id.tarjetaNostros_NoCtrl)
            itemCarrera = itemView.findViewById(R.id.tarjetaNosotrs_Carrera)
            itemFoto =    itemView.findViewById(R.id.tarjetaNosotros_foto)
        }
    }
}