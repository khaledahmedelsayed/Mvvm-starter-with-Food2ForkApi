package com.hemdan.mvvm.ui.home

import androidx.lifecycle.MutableLiveData
import com.hemdan.mvvm.data.model.Recipe
import com.hemdan.mvvm.ui.base.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeRepository>() {
    @Inject
    override lateinit var repository: HomeRepository

    val responseList = MutableLiveData<List<Recipe?>>()

    fun loadFoodList() {
        subscribe(repository.getFoodList(), Consumer {
            responseList.value = it.recipes
        })
    }

}