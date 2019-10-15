package com.khaled.food2fork.data.api

import com.khaled.food2fork.data.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Food2ForkApi {
    @GET("/api/search?")
    fun getFoodList(@Query("page") page: Int): Single<SearchResponse>

    companion object {
        const val API_KEY = "5e4afa385efc03a560b10876af192563"
        const val PARAM_API_KEY = "key"
    }
}