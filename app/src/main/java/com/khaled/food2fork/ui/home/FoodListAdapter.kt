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

class FoodListAdapter(
    private val responseList: ArrayList<Recipe?>
) : RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe: Recipe? = responseList[position]
        holder.bind(recipe)
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        private val mImageView: ImageView = mView.findViewById(R.id.iv_image)
        private val mTextView: TextView = mView.findViewById(R.id.tv_title)
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