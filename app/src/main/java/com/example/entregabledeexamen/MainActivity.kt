package com.example.entregabledeexamen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.entregabledeexamen.databinding.ActivityMainBinding
import com.example.examen.Agenda

class MainActivity : AppCompatActivity() {
    private val contactos = mutableListOf<Agenda>()
    private lateinit var binding: ActivityMainBinding // Utilizamos el objeto de enlace generado

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inflar la vista utilizando el enlace
        val view = binding.root
        setContentView(view)

        val btnAgregar = binding.buttonAgregar
        val btnVerAgenda = binding.buttonVerAgenda

        btnAgregar.setOnClickListener {
            val nombre = binding.txtNombreC.text.toString()
            val noControl = binding.txtnoControl.text.toString()

            if (nombre.isNotBlank() && noControl.isNotBlank()) {
                contactos.add(Agenda(nombre, noControl))
                binding.txtcontactos.text = "Contactos: ${contactos.size}"
                binding.txtNombreC.text.clear()
                binding.txtnoControl.text.clear()
            } else {
                // Mostrar un mensaje de error al usuario si los campos están vacíos
                Toast.makeText(this, "Por favor, completa ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnVerAgenda.setOnClickListener {
            val intent = Intent(this, AgendaDetalleActivity::class.java)
            val existe = contactos.find { it.nocontrol == binding.txtNumero.text.toString()}
            if (existe != null) {
                intent.putExtra("nombreContacto", existe?.nombre)
                startActivity(intent)
                binding.txtNumero.text.clear()
            } else {
                // Mostrar un mensaje de error al usuario si los campos están vacíos
                Toast.makeText(this, "Número no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
