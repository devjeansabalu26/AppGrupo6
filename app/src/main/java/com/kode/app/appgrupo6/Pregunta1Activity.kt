package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kode.app.appgrupo6.databinding.ActivityPregunta1Binding
import java.util.Locale

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    companion object {
        private const val LONGITUD_MAXIMA = 12.0
        private const val CARGO_BASE = 400.0
        private const val COSTO_METRO_EXCESO = 120.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnCalcular -> calcularSobrecargo()
        }
    }

    private fun calcularSobrecargo() {
        val texto = binding.etLongitud.text.toString().trim()

        if (texto.isEmpty()) {
            mostrarError(getString(R.string.pregunta1_error_vacio))
            return
        }

        val longitud = texto.toDoubleOrNull()
        if (longitud == null) {
            mostrarError(getString(R.string.pregunta1_error_invalido))
            return
        }

        if (longitud <= 0) {
            mostrarError(getString(R.string.pregunta1_error_no_positivo))
            return
        }

        if (longitud <= LONGITUD_MAXIMA) {
            binding.tvResultado.text = getString(R.string.pregunta1_dentro_limite)
            return
        }

        val exceso = longitud - LONGITUD_MAXIMA
        val sobrecargo = CARGO_BASE + (COSTO_METRO_EXCESO * exceso)

        binding.tvResultado.text = String.format(
            Locale.US,
            getString(R.string.pregunta1_resultado),
            longitud,
            exceso,
            sobrecargo
        )
    }

    private fun mostrarError(mensaje: String) {
        binding.etLongitud.error = mensaje
        binding.tvResultado.text = ""
    }
}
