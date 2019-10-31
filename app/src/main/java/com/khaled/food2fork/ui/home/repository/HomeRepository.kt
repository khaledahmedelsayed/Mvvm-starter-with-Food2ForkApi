package com.khaled.food2fork.ui.home.repository

import com.khaled.food2fork.data.api.Food2ForkApi
import com.khaled.food2fork.ui.base.BaseRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeRepository : BaseRepository(), KoinComponent {

    override val apiService: Food2ForkApi by inject()

    fun getRecipesResult(page: Int) = apiService.getFoodList(page)
}