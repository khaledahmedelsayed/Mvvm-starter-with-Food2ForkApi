package com.khaled.food2fork.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.khaled.food2fork.data.model.Recipe

class DataSourceFactory constructor(private val repository: HomeRepository, private val viewModel: HomeViewModel) :
    DataSource.Factory<Int, Recipe>() {

    private val newsDataSourceLiveData = MutableLiveData<com.khaled.food2fork.ui.home.DataSource>()

    override fun create(): DataSource<Int, Recipe> {
        val newsDataSource = DataSource(repository,viewModel)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}