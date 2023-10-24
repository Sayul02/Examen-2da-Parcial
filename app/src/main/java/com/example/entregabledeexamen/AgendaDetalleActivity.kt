package com.example.entregabledeexamen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.entregabledeexamen.databinding.AgendaDetalleBinding // Importa la clase de enlace generada

class AgendaDetalleActivity : AppCompatActivity() {
    private lateinit var binding: AgendaDetalleBinding // Utiliza el objeto de enlace generado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AgendaDetalleBinding.inflate(layoutInflater) // Infla la vista utilizando el enlace
        val view = binding.root
        setContentView(view)

        val nombreContacto = intent.getStringExtra("nombreContacto").toString()

        binding.txtverNombre.text = "Nombre del Contacto: $nombreContacto"

        binding.buttonSalir.setOnClickListener {
            finish()
        }
    }
}
