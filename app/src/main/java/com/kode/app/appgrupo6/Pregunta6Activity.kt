package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kode.app.appgrupo6.databinding.ActivityPregunta6Binding
import java.util.Locale

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Inicializar el binding
        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        // 2. Mostrar la vista usando binding.root en lugar de R.layout...
        setContentView(binding.root)

        setContentView(R.layout.activity_pregunta6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Escuchar el clic del botón btnresult
        binding.btnResultado.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // 4. Redirigir el clic a la función de cálculo
        when (v?.id) {
            binding.btnResultado.id -> calcularCobroExtra()
        }
    }

    private fun calcularCobroExtra() {
        val kilometrosTexto = binding.etKilometros.text.toString()

        if (kilometrosTexto.isEmpty()) {
            binding.tvResult.text = "Por favor ingrese los kilómetros recorridos."
            return
        }

        val kilometros = kilometrosTexto.toDouble()

        if (kilometros <= 200) {
            binding.tvResult.text = "Recorrido cubierto por la tarifa contratada."
        } else {
            val extra = kilometros - 200
            val cobro = 50.00 + (1.20 * extra)

            binding.tvResult.text = String.format(
                Locale.getDefault(),
                "Kilómetros registrados: %.2f km\nKilómetros extra: %.2f km\nTotal a pagar por kilometraje excedente: S/ %.2f",
                kilometros, extra, cobro
            )
        }
    }
}