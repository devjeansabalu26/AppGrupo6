package com.kode.app.appgrupo6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pregunta4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etHoras = findViewById<android.widget.EditText>(R.id.etHoras)
        val btnCalcular = findViewById<android.widget.Button>(R.id.btnCalcular)
        val tvResultado = findViewById<android.widget.TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val horasTexto = etHoras.text.toString()

            if (horasTexto.isNotEmpty()) {
                val horas = horasTexto.toInt()

                if (horas <= 48) {
                    tvResultado.text = "Almacenamiento cubierto por la tarifa base."
                } else {
                    val exceso = horas - 48
                    val costo = 90.00 + (12.00 * exceso)
                    val costoFormateado = String.format("S/ %.2f", costo)

                    tvResultado.text = "Horas de permanencia: $horas\nExceso de tiempo: $exceso\nCargo por estadía prolongada: $costoFormateado"
                }
            } else {
                tvResultado.text = "Por favor, ingrese un número de horas."
            }
        }
    }
}