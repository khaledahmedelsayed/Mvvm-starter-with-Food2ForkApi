package com.khaled.food2fork.ui.home

import androidx.paging.PageKeyedDataSource
import com.khaled.food2fork.data.model.Recipe
import io.reactivex.functions.Consumer

class DataSource(private val repository: HomeRepository, private val viewModel: HomeViewModel) :
    PageKeyedDataSource<Int, Recipe>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Recipe>
    ) {
        viewModel.subscribe(repository.getRecipesResult(1), Consumer { response ->
            callback.onResult(
                response.recipes,
                null,
                2
            )
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
        viewModel.subscribe(repository.getRecipesResult(params.key), Consumer { response ->
            callback.onResult(
                response.recipes,
                params.key+1
            )
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Recipe>) {
    }
}