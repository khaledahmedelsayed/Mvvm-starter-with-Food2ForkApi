package com.khaled.food2fork.data.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("f2f_url")
    val f2fUrl: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("publisher_url")
    val publisherUrl: String,
    @SerializedName("recipe_id")
    val recipeId: String,
    @SerializedName("social_rank")
    val socialRank: Double,
    @SerializedName("source_url")
    val sourceUrl: String,
    @SerializedName("title")
    val title: String
)