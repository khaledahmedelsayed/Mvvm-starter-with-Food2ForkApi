package com.khaled.food2fork.data.api

import com.khaled.food2fork.data.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Food2ForkApi {
    @GET("/api/search?")
    fun getFoodList(): Single<SearchResponse>

    companion object {
        const val API_KEY = "98151c44a97793ce88aee9216c84f4f9"
        const val PARAM_API_KEY = "key"
    }
}