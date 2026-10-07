package com.kode.app.appgrupo6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pregunta6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta6)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sampleRecipes = listOf(
            Recipe("1", "Lomo Saltado", "25 mins", "Media", "Peruana"),
            Recipe("2", "Ají de Gallina", "35 mins", "Media", "Peruana"),
            Recipe("3", "Ceviche", "15 mins", "Fácil", "Peruana"),
            Recipe("4", "Causa Rellena", "30 mins", "Fácil", "Peruana")
        )

        recyclerView.adapter = RecipeAdapter(sampleRecipes)
    }
}