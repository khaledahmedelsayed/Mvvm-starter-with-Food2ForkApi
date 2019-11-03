package com.khaled.food2fork.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.khaled.food2fork.data.model.Recipe
import com.khaled.food2fork.ui.base.BaseViewModel
import com.khaled.food2fork.ui.home.repository.HomeRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel : BaseViewModel<HomeRepository>(), KoinComponent {

    override val repository by inject<HomeRepository>()
    var recipesList: MutableLiveData<ArrayList<Recipe?>> = MutableLiveData()

    fun loadRecipesList(page: Int) {

        //runs in background
        GlobalScope.launch {
            recipesList.postValue(repository.getRecipesResult(page).recipes)
        }

        // blocks current thread until it finishes
//        runBlocking {
//            recipesList.value = repository.getRecipesResult(page).recipes
//        }
    }
}