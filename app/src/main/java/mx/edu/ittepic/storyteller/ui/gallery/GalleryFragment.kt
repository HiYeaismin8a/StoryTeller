package mx.edu.ittepic.storyteller.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import mx.edu.ittepic.storyteller.Adapter_TarjetaNosotros
import mx.edu.ittepic.storyteller.Demo
import mx.edu.ittepic.storyteller.R
import mx.edu.ittepic.storyteller.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private var imagenes = arrayOf(R.drawable.integrante_uno,R.drawable.integrante_dos, R
        .drawable.integrante_tres, R.drawable.integrante_cuatro)
    private var estudiantes = arrayOf("Daniel López Quintero", "Jazmin Ochoa Benitez",
        "Cristopher David Canalez", " Juan Mata Solis")
    private var noctrl = arrayOf("This", "Two", "Three", "Two")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView
        val adapter = Adapter_TarjetaNosotros(estudiantes, noctrl, imagenes,  object :
            Adapter_TarjetaNosotros
        .onItemClick {
            override fun verClick(position: Int) {
                val intent = Intent(activity, Demo::class.java)
                startActivity(intent)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}