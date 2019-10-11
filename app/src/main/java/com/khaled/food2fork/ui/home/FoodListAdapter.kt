package com.khaled.food2fork.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khaled.food2fork.R
import com.khaled.food2fork.data.model.Recipe
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recipe.view.*

class FoodListAdapter : RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {
    private var recipesList = ArrayList<Recipe?>()

    fun insertList(recipesList: ArrayList<Recipe?>) {
        this.recipesList.addAll(recipesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe: Recipe? = recipesList[position]
        holder.bind(recipe)
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        private val mImageView = mView.ivImage
        private val mTextView = mView.tvTitle
        fun bind(recipe: Recipe?) {
            mTextView.text = recipe?.title
            Picasso.get()
                .load(recipe?.imageUrl)
                .resize(250, 250)
                .into(mImageView, object : Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {
                        mImageView.setImageResource(R.drawable.no_image)
                    }
                })
        }
    }

}