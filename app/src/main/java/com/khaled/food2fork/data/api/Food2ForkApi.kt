package com.khaled.food2fork.data.api

import com.khaled.food2fork.data.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Food2ForkApi {
    @GET("/api/search?")
    fun getFoodList(@Query("page") page: Int): Single<SearchResponse>

    companion object {
        const val API_KEY = "98151c44a97793ce88aee9216c84f4f9"
        const val PARAM_API_KEY = "key"
    }
}