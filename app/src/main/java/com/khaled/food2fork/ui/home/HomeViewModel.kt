package com.khaled.food2fork.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.khaled.food2fork.data.model.Recipe
import com.khaled.food2fork.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeRepository>() {

    @Inject
    override lateinit var repository: HomeRepository

    var responseList: LiveData<PagedList<Recipe>> = MutableLiveData()
    private val foodDataSourceFactory: FoodDataSourceFactory
init {
     foodDataSourceFactory = FoodDataSourceFactory(this) //Must be initialized before setting recyclerView adapter

}
    fun getFoodRecipes() {

        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(30)
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        responseList = LivePagedListBuilder(foodDataSourceFactory, config).build()

    }


}