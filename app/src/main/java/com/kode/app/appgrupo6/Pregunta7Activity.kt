package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityPregunta7Binding

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular7.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular7 -> calcularCargoAnden()
        }
    }

    private fun calcularCargoAnden() {
        val minutosTexto = binding.etMinutos.text.toString().trim()

        if (minutosTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese los minutos en andén", Toast.LENGTH_SHORT).show()
            return
        }

        val minutosUso = minutosTexto.toIntOrNull()

        if (minutosUso == null || minutosUso < 0) {
            Toast.makeText(this, "Ingrese un número de minutos válido", Toast.LENGTH_SHORT).show()
            return
        }
        if (minutosUso <= 45) {
            binding.tvResultado7.text = "Maniobra terminada dentro del tiempo asignado."
        } else {
            val excesoPermanencia = minutosUso - 45
            val cargoOcupacion = 70.00 + (excesoPermanencia * 4.00)

            val resultadoDetalle = """
                • Minutos de uso: $minutosUso
                • Exceso de permanencia: $excesoPermanencia min
                • Cargo por ocupación extraordinaria: S/ %.2f
            """.trimIndent().format(cargoOcupacion)

            binding.tvResultado7.text = resultadoDetalle
        }
    }
}