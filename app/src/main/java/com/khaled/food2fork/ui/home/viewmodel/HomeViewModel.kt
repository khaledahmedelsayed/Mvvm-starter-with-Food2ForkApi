package com.khaled.food2fork.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.khaled.food2fork.data.model.Recipe
import com.khaled.food2fork.ui.base.BaseViewModel
import com.khaled.food2fork.ui.home.repository.HomeRepository
import io.reactivex.functions.Consumer
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel : BaseViewModel<HomeRepository>(), KoinComponent {

    override val repository by inject<HomeRepository>()

    var responseList: MutableLiveData<ArrayList<Recipe?>> = MutableLiveData()

    fun loadFoodList() {
        subscribe(repository.getRecipesResult(1), Consumer {
            responseList.value = it.recipes
        })
    }
}