package com.kode.app.appgrupo6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPregunta1.setOnClickListener(this)
        binding.btnPregunta2.setOnClickListener(this)
        binding.btnPregunta3.setOnClickListener(this)
        binding.btnPregunta4.setOnClickListener(this)
        binding.btnPregunta5.setOnClickListener(this)
        binding.btnPregunta6.setOnClickListener(this)
        binding.btnPregunta7.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPregunta1 -> {
                startActivity(Intent(this, Pregunta1Activity::class.java))
            }
            R.id.btnPregunta2 -> {
                startActivity(Intent(this, Pregunta2Activity::class.java))
            }
            R.id.btnPregunta3 -> {
                startActivity(Intent(this, Pregunta3Activity::class.java))
            }
            R.id.btnPregunta4 -> {
                startActivity(Intent(this, Pregunta4Activity::class.java))
            }
            R.id.btnPregunta5 -> {
                startActivity(Intent(this, Pregunta5Activity::class.java))
            }
            R.id.btnPregunta6 -> {
                startActivity(Intent(this, Pregunta6Activity::class.java))
            }
            R.id.btnPregunta7 -> {
                startActivity(Intent(this, Pregunta7Activity::class.java))
            }
        }
    }
}