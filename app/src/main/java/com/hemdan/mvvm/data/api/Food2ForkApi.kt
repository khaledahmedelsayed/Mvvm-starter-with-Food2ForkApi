package com.hemdan.mvvm.data.api

import com.hemdan.mvvm.data.model.Food2ForkSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Food2ForkApi {
    @GET("/search?")
    fun getFoodList(@Query("page") page: String): Single<Food2ForkSearchResponse>

    companion object {
        const val API_KEY = "98151c44a97793ce88aee9216c84f4f9"
        const val PARAM_API_KEY = "key"
    }
}