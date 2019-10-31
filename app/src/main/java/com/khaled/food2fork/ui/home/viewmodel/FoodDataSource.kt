package com.khaled.food2fork.ui.home.viewmodel

import androidx.paging.PageKeyedDataSource
import com.khaled.food2fork.data.model.Recipe
import io.reactivex.functions.Consumer
import org.koin.core.KoinComponent
import org.koin.core.inject

class FoodDataSource : PageKeyedDataSource<Int, Recipe>(), KoinComponent {

    private val viewModel by inject<HomeViewModel>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Recipe>
    ) {

        viewModel.subscribe(viewModel.repository.getRecipesResult(1), Consumer { response ->
            callback.onResult(
                response.recipes,
                null,
                2
            )
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
        viewModel.subscribe(
            viewModel.repository.getRecipesResult(params.key),
            Consumer { response ->
                callback.onResult(
                    response.recipes,
                    params.key + 1
                )
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
    }
}