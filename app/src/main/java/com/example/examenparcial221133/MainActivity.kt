package com.example.examenparcial221133

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var Gatos: ImageView? = null
    private var Perfil: ImageView? = null
    private var Configuracion: ImageView? = null
    private var Cerrar: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        INICIARVISTAS()
        clickeos()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun INICIARVISTAS() {
        Gatos = findViewById(R.id.ivCat)
        Perfil = findViewById(R.id.ivProfile)
        Configuracion = findViewById(R.id.ivConfig)
        Cerrar = findViewById(R.id.ivCerrar)
    }
    private fun clickeos(){
        Gatos?.setOnClickListener(this)
        Perfil?.setOnClickListener(this)
        Configuracion?.setOnClickListener(this)
        Cerrar?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {

            R.id.ivCerrar -> {
                finish()
            }
            R.id.ivProfile -> {
                val D = Intent(this, Preferencias::class.java)
                startActivity(D)

            }
        }
    }

}