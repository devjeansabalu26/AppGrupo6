package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import com.kode.app.appgrupo6.databinding.ActivityPregunta3Binding
class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularPenalidad()
        }
    }

    private fun calcularPenalidad() {
        val minutosTexto = binding.etMinutos.text.toString()

        if (minutosTexto.isEmpty()) {
            binding.tvResultado.text = "Por favor ingrese los minutos de retraso."
            return
        }

        val minutos = minutosTexto.toDouble()

        if (minutos <= 15) {
            binding.tvResultado.text = "Entrega dentro de la tolerancia operativa."
        } else {
            val exceso = minutos - 15
            val penalidad = 15.00 + (2.50 * exceso)

            binding.tvResultado.text = String.format(
                Locale.getDefault(),
                "Minutos reportados: %.0f min\nMinutos de exceso: %.0f min\nMonto de la penalidad: S/ %.2f",
                minutos, exceso, penalidad
            )
        }
    }
}