package com.khaled.food2fork.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.khaled.food2fork.data.model.Recipe
import javax.inject.Inject

class ItemDataSourceFactory @Inject constructor()
    : DataSource.Factory<Int, Recipe>() {

    private val newsDataSourceLiveData = MutableLiveData<ItemDataSource>()

    override fun create(): DataSource<Int, Recipe> {
        val newsDataSource = ItemDataSource()
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}