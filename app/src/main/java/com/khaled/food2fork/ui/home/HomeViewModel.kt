package com.khaled.food2fork.ui.home

import androidx.lifecycle.MutableLiveData
import com.khaled.food2fork.data.model.Recipe
import com.khaled.food2fork.ui.base.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeRepository>() {
    @Inject
    override lateinit var repository: HomeRepository

    val responseList = MutableLiveData<ArrayList<Recipe?>>()

    fun loadFoodList() {
        subscribe(repository.getFoodList(), Consumer {
            responseList.value = it.recipes
        })
    }

}