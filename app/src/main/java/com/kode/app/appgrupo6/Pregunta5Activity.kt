package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityPregunta5Binding
import java.util.Locale

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularMulta()
        }
    }

    private fun calcularMulta() {

        val pesoTexto = binding.etPeso.text.toString()
        if (pesoTexto.isEmpty()) {
            binding.tvResultado.text =
                "Por favor ingrese el peso del camión."
            return
        }

        val peso = pesoTexto.toDouble()

        if (peso <= 18) {

            binding.tvResultado.text =
                "Vehículo con carga reglamentaria autorizada."

        } else {

            val exceso = peso - 18

            val multa = 1800.00 + (650.00 * exceso)

            binding.tvResultado.text = String.format(
                Locale.getDefault(),
                "Peso registrado: %.2f t\n" +
                        "Exceso de carga: %.2f t\n" +
                        "Multa calculada: S/ %.2f",
                peso,
                exceso,
                multa
            )
        }
    }
}