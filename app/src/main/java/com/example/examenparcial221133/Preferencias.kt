package com.example.examenparcial221133

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferencias : AppCompatActivity() {
    private lateinit var texto : TextView
    private lateinit var etNombre: EditText
    private lateinit var etNombreGato: EditText
    private lateinit var etEdad: EditText
    private lateinit var bnGuardar: FloatingActionButton
    private val NOMBRE_KEY = "nombre"
    private val NombreGato_KEY = "nombregato"
    private val Edad_KEY = "edad"
    private var nombre: String = ""
    private var nombre_gato: String = ""
    private var edad: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PREFERENCIAS","OnCreate")
        setContentView(R.layout.activity_preferencias)
        iniciarVistas()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NOMBRE_KEY, nombre )
        outState.putInt(Edad_KEY, edad )
        outState.putString(NombreGato_KEY,nombre_gato)
        outState?.run {
            putString(NOMBRE_KEY, nombre)
            putInt(Edad_KEY, edad )
            putString(NombreGato_KEY,nombre_gato)
        }
// call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")
        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre = miSharedPreferences.getString(NOMBRE_KEY, "").toString()
            edad = miSharedPreferences.getInt(Edad_KEY, 0)
            nombre_gato = miSharedPreferences.getString(NombreGato_KEY, "").toString()

        }
        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS", "onDestroy")
        super.onDestroy()
    }

    private fun iniciarVistas(){
        etNombre = findViewById(R.id.Nombre)
        etNombreGato = findViewById(R.id.nombreGato)
        etEdad = findViewById(R.id.Edad)
        texto = findViewById(R.id.textView)
        bnGuardar = findViewById(R.id.floatingActionButton)

        bnGuardar.setOnClickListener{
            nombre = etNombre.text.toString()
            nombre_gato = etNombreGato.text.toString()
            edad = etEdad.text.toString().toInt()
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = miSharedPreferences.edit()
            editor.putString(NOMBRE_KEY, nombre)
            editor.putString(NombreGato_KEY, nombre_gato)
            editor.putInt(Edad_KEY, edad)
            editor.apply()

            texto.text = "Con Datos Previamente Guardados"
            val S = Intent(this, MainActivity2::class.java)
            startActivity(S)


        }
    }
}