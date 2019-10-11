package com.hemdan.mvvm.ui.home

import com.hemdan.mvvm.data.api.Food2ForkApi
import com.hemdan.mvvm.data.model.SearchResponse
import com.hemdan.mvvm.ui.base.BaseRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor() : BaseRepository() {
    @Inject
    lateinit var apiService: Food2ForkApi

    fun getFoodList(): Single<SearchResponse> {
        return apiService.getFoodList()
    }
}
