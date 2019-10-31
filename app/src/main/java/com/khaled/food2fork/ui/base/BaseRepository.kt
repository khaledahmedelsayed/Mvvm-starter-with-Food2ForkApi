package com.khaled.food2fork.ui.base

import com.khaled.food2fork.data.api.Food2ForkApi

abstract class BaseRepository {

    abstract val apiService: Food2ForkApi
}