package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityPregunta2Binding

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> procesarDemurrage()
        }
    }

    private fun procesarDemurrage() {
        val diasTexto = binding.etDias.text.toString().trim()

        if (diasTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese los días transcurridos", Toast.LENGTH_SHORT).show()
            return
        }

        val diasTotales = diasTexto.toIntOrNull()

        if (diasTotales == null || diasTotales < 0) {
            Toast.makeText(this, "Ingrese un número entero de días válido", Toast.LENGTH_SHORT).show()
            return
        }


        if (diasTotales <= 7) {
            binding.tvResultado.text = "Contenedor retornado dentro de los días libres."
        } else {
            val diasMora = diasTotales - 7
            val montoDemurrage = 200.00 + (diasMora * 75.00)

            val resultadoDetalle = """
                • Días totales transcurridos: $diasTotales
                • Días de mora: $diasMora
                • Monto de demurrage liquidado: S/ %.2f
            """.trimIndent().format(montoDemurrage)

            binding.tvResultado.text = resultadoDetalle
        }
    }
}