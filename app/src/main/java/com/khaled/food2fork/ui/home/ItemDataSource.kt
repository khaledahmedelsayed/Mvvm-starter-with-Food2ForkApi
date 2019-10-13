package com.khaled.food2fork.ui.home

import androidx.paging.PageKeyedDataSource
import com.khaled.food2fork.data.api.Food2ForkApi
import com.khaled.food2fork.data.model.Recipe
import javax.inject.Inject

class ItemDataSource : PageKeyedDataSource<Int, Recipe>() {
    @Inject
    lateinit var apiService: Food2ForkApi

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Recipe>
    ) {
        apiService.getFoodList(1).subscribe(
            { response ->
                callback.onResult(response.recipes,
                    null,
                    2
                )
            },
            {
            }
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
        apiService.getFoodList(params.key).subscribe(
            { response ->
                callback.onResult(response.recipes,
                    params.key + 1
                )
            },
            {
            }
        )    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
    }
}