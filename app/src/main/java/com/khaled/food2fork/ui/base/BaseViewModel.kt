package com.khaled.food2fork.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khaled.food2fork.data.utils.ErrorModel

abstract class BaseViewModel<Repository : BaseRepository> : ViewModel() {

    abstract val repository: Repository

    val error = MutableLiveData<ErrorModel>()
    val loading = MutableLiveData<Boolean>()
}