package mx.edu.ittepic.storyteller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_inicio.*

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //Animaciion
        val btt = AnimationUtils.loadAnimation(this, R.anim.btt)

        login_btnIngresar.startAnimation(btt)
        login_lblBienvenido.startAnimation(btt)
        login_lblDemo.startAnimation(btt)

        login_btnIngresar.setOnClickListener {
            startActivity(Intent(this, Contenido::class.java))
        }
    }
}