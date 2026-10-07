package com.kode.app.appgrupo6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPrepTime: TextView = itemView.findViewById(R.id.tvPrepTime)
        val tvDifficulty: TextView = itemView.findViewById(R.id.tvDifficulty)
        val tvCuisine: TextView = itemView.findViewById(R.id.tvCuisine)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.tvId.text = "ID: ${recipe.id}"
        holder.tvName.text = recipe.name
        holder.tvPrepTime.text = "Tiempo: ${recipe.prepTime}"
        holder.tvDifficulty.text = "Dificultad: ${recipe.difficulty}"
        holder.tvCuisine.text = "Cocina: ${recipe.cuisine}"
    }

    override fun getItemCount(): Int = recipeList.size
}