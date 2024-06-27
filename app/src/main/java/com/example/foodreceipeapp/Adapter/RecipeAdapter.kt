package com.example.foodreceipeapp.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodreceipeapp.Model.Receipe

private class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder?>() {
    private val recipes: List<Receipe>? = null
    private val listener: OnRecipeClickListener? = null

    // ... onCreateViewHolder, onBindViewHolder, getItemCount ...
    internal inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ... view references and constructor ...
        fun bind(recipe: Receipe?) {
            // ... bind recipe data to views ...
        }
    }

    interface OnRecipeClickListener {
        fun onRecipeClick(recipe: Receipe?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
