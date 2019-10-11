package com.khaled.food2fork.ui.home

import com.khaled.food2fork.data.api.Food2ForkApi
import com.khaled.food2fork.data.model.SearchResponse
import com.khaled.food2fork.ui.base.BaseRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor() : BaseRepository() {
    @Inject
    lateinit var apiService: Food2ForkApi

    fun getFoodList(): Single<SearchResponse> {
        return apiService.getFoodList()
    }
}