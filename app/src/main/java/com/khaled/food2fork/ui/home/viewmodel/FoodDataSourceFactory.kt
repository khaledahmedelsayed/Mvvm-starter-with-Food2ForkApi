package com.khaled.food2fork.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.khaled.food2fork.data.model.Recipe

class FoodDataSourceFactory constructor(private val viewModel: HomeViewModel) :
    DataSource.Factory<Int, Recipe>() {

    private val newsDataSourceLiveData = MutableLiveData<FoodDataSource>()

    override fun create(): DataSource<Int, Recipe> {
        val newsDataSource = FoodDataSource(viewModel)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}