package com.example.ladm_u2_storytellers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_inicio.*

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //Animaciion
        val btt = AnimationUtils.loadAnimation(this, R.anim.btt)

        lg_btnIngresar.startAnimation(btt)
        lg_lblBienvenido.startAnimation(btt)
        lg_lblDemo.startAnimation(btt)
        lg_ui_titleBackground.startAnimation(btt)

        lg_btnIngresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}