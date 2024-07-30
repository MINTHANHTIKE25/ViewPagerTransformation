package com.minthanhtike.swipeablewithframlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyPagerAdapter(private val recipes: List<String>) : RecyclerView.Adapter<MyPagerAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImage: ImageView = itemView.findViewById(R.id.recipe_image)
        val overlayText: TextView = itemView.findViewById(R.id.overlay_text)
        val bookmarkButton: ImageButton = itemView.findViewById(R.id.bookmark_button)
        val timeText: TextView = itemView.findViewById(R.id.time_text)
        val recipeName: TextView = itemView.findViewById(R.id.recipe_name)
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        if(position%2 == 0){
            holder.recipeImage.setImageResource(R.drawable.ic_launcher_background)
        }
        // Bind your data here
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}
