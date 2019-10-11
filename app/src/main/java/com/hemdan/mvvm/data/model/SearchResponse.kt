package com.hemdan.mvvm.data.model

import com.google.gson.annotations.SerializedName


data class SearchResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("recipes")
    val recipes: ArrayList<Recipe>
)