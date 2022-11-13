package mx.edu.ittepic.storyteller.ui.home

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*
import mx.edu.ittepic.storyteller.Adapter_TarjetInicio
import mx.edu.ittepic.storyteller.Demo
import mx.edu.ittepic.storyteller.R
import mx.edu.ittepic.storyteller.databinding.FragmentHomeBinding
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var libros = arrayOf("This, Two, Three, Two")

    private var libros_nombre = arrayOf("The Gluttonous Fox, Snow White, Little red riding hood, Pinoccho")
    private var libros_descripcion = arrayOf("A gluttonous fox in a pitch, Snow White and the Seven Dwarfs, In the forest and the wolf, Wish becoming reality")
    private var libros_tags = arrayOf("Fantasy, Realm, Kids, Lessons")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView
        val adapter = Adapter_TarjetInicio(libros, libros_nombre, libros_descripcion, libros_tags, object : Adapter_TarjetInicio.onItemClick {
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