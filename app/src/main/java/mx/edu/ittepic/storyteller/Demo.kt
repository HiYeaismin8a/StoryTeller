package mx.edu.ittepic.storyteller

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.coroutines.*
import mx.edu.ittepic.storyteller.databinding.ActivityContenidoBinding.inflate
import mx.edu.ittepic.storyteller.databinding.ActivityDemoBinding
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class Demo : AppCompatActivity() {
    //Variables
    lateinit var binding: ActivityDemoBinding
    private var parrafos = arrayOf(
        "On one great day, a curious fox ? a basket of food that some farmers had left behind in the hole of a " +
                "tree",
        "Making ? as small as he could, he passed through the narrow hole so other animals wouldn’t see him gobbling up that rich banquet.",
        "And so the ? fox ate, and ate, and ate even more. He had never eaten so much in his entire life!, but when " +
                "it was all over and he ? to get out of the tree, he couldn’t move an inch.",
        "He had grown too fat to climb out of the hole!.",
        "But the gluttonous fox did not realize that he had eaten so much that he though the tree had become ?. ",
        "He poked his head out of the hole and yelled:",
        "?!, Help!, someone help me out of this horrible trap.",
        "At that very moment a weasel ? by, seeing it the fox exclaimed:",
        "-	Hey weasel, help me out please. The tree is shrinking down and is ?. ",
        "“It doesn’t seem that way to me”, the little weasel laughed. “The tree is just as ? as when I saw it this morning”, perhaps you just gained more weight. ",
        "-	Don’t talk nonsense and get me out of here!, the fox screeched back at him. “I’m dying, seriously”.",
        "To this the weasel ?:  ",
        "“You got it coming for eating too much. “. The bad thing is that your eyes are bigger than your stomach. And so you’ll have to stay there until you lose weight… and then you can go out. ",
        "This way you will ? not to be so gluttonous.",
        "The poor fox had to stay two days and two nights in his sad confinement. And so he yelled: “I will never eat this much ever ?!. ",
    )
    private val respuestas = arrayOf(
        "found", "himself", "gluttonous", "tried", "smaller", "Help", "passed",
        "crushing me", "big", "replied", "learn", "again"
    )

    private val audios = arrayOf(
        R.raw.parte1, R.raw.parte2, R.raw.parte3, R.raw.parte4, R.raw.parte5, R.raw.parte6, R
            .raw.parte7, R.raw.parte8, R.raw.parte9, R.raw.parte10, R.raw.parte11, R.raw.parte12, R.raw.parte13, R.raw
            .parte14, R.raw.parte15
    )

    private var actual = 0
    private var correcta = false
    private val scope = CoroutineScope(Job() + Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.demoContenido.isVisible = false
        binding.textoCuento.isVisible = false
        binding.repetir.isVisible = false
        binding.demoHint.isVisible = false

        binding.homeBtnIniciar.setOnClickListener {


            contarCuento.start()
            binding.repetir.setOnClickListener { finish() }

            binding.demoContenido.isVisible = true
            binding.textoCuento.isVisible = true
            binding.repetir.isVisible = true
            binding.homeLblInicio.setText("Empecemos!")
            binding.homeBtnIniciar.isVisible = false
            binding.demoHint.isVisible = true
        }
    }

    //Funciones
    private val contarCuento = scope.launch(EmptyCoroutineContext, CoroutineStart.LAZY) {
        delay(1500)
        do {
            this@Demo.runOnUiThread {
                binding.textoCuento.text = parrafos[actual]
                binding.opcion1.isEnabled = false
                binding.opcion2.isEnabled = false
                binding.opcion3.isEnabled = false
            }

            reproducir(audios[actual])
            correcta = false
            val opcion = (0..2).random(Random(System.currentTimeMillis()))
            ponerAlerts(opcion)
            this@Demo.runOnUiThread {
                binding.opcion1.isEnabled = true
                binding.opcion2.isEnabled = true
                binding.opcion3.isEnabled = true
            }
            while (!correcta) {

            }
        } while (actual < respuestas.size)
    }

    fun ponerAlerts(correcto: Int) {
        when (correcto) {
            0 -> {
                this@Demo.runOnUiThread { binding.opcion1.text = respuestas[actual++] }
                var texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion2.text = if (texto != binding.opcion1.text.toString()) texto else "goes"
                }
                texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion3.text = if (texto != binding.opcion1.text.toString()) texto else "goes"
                }

                binding.opcion1.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA CORRECTA").setMessage("Su respuesta ha sido correcta")
                        .setPositiveButton("Continuar") { d, _ ->
                            correcta = true
                            d.dismiss()
                        }
                        .show()
                }

                binding.opcion2.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }
                binding.opcion3.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }

            }
            1 -> {
                this@Demo.runOnUiThread { binding.opcion2.text = respuestas[actual++] }
                var texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion1.text = if (texto != binding
                            .opcion2.text.toString()
                    ) texto else "goes"
                }
                texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion3.text = if (texto != binding
                            .opcion2.text.toString()
                    ) texto else "goes"
                }

                binding.opcion2.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA CORRECTA").setMessage("Su respuesta ha sido correcta")
                        .setPositiveButton("Continuar") { d, _ ->
                            correcta = true
                            d.dismiss()
                        }
                        .show()
                }

                binding.opcion1.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }
                binding.opcion3.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }
            }
            2 -> {
                this@Demo.runOnUiThread { binding.opcion3.text = respuestas[actual++] }
                var texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion1.text = if (texto != binding
                            .opcion3.text.toString()
                    ) texto else "goes"
                }
                texto = respuestas.random(Random(System.currentTimeMillis()))
                this@Demo.runOnUiThread {
                    binding.opcion2.text = if (texto != binding
                            .opcion3.text.toString()
                    ) texto else "goes"
                }

                binding.opcion3.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA CORRECTA").setMessage("Su respuesta ha sido correcta")
                        .setPositiveButton("Continuar") { d, _ ->
                            correcta = true
                            d.dismiss()
                        }
                        .show()
                }

                binding.opcion1.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }
                binding.opcion2.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("RESPUESTA INCORRECTA").setMessage("Su respuesta no es la correcta")
                        .setPositiveButton("Continuar") { d, _ -> d.dismiss() }.show()
                }
            }
        }
    }

    fun reproducir(audio: Int) {
        val reproductor = MediaPlayer.create(this, audio)
        reproductor.start()
        while (reproductor.isPlaying) {
        }
    }
}