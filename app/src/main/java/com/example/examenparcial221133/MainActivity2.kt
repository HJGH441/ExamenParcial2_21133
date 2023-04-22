package com.example.examenparcial221133

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var bnback = findViewById<Button>(R.id.volver)
    var Nombre = findViewById<TextView>(R.id.Nombre1)
    var Edad = findViewById<TextView>(R.id.Edad1)
    var Nombr = findViewById<TextView>(R.id.Nombregato1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)



        val sharedPreference = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE) ?: return
        val nombre = sharedPreference.getString("nombre", "")
        val edad = sharedPreference.getInt("edad", 0).toString()
        val nombr = sharedPreference.getString("nombregato", "")
        Nombre.text = nombre
        Edad.text = edad
        Nombr.text = nombr

        bnback.setOnClickListener{
            val s = Intent(this, Preferencias::class.java)
            startActivity(s)
            finish()
        }


    }
}