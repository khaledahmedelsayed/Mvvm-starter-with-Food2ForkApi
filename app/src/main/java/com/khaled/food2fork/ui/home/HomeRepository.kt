package com.khaled.food2fork.ui.home

import com.khaled.food2fork.data.api.Food2ForkApi
import com.khaled.food2fork.ui.base.BaseRepository
import javax.inject.Inject

class HomeRepository @Inject constructor() : BaseRepository() {
    @Inject
    lateinit var apiService: Food2ForkApi

    fun getRecipesResult(page: Int) = apiService.getFoodList(page)
}