package com.khaled.food2fork.ui.home

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.khaled.food2fork.data.model.Recipe
import com.khaled.food2fork.ui.base.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeRepository>() {
    @Inject
    override lateinit var repository: HomeRepository

    var responseList : LiveData<PagedList<Recipe?>>
    var itemDataSourceFactory : ItemDataSourceFactory = ItemDataSourceFactory()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setInitialLoadSizeHint(30* 2)
            .setEnablePlaceholders(false)
            .build()
        responseList = LivePagedListBuilder<Int, Recipe>(itemDataSourceFactory,config).build()
    }


}