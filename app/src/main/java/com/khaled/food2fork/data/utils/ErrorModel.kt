package com.khaled.food2fork.data.utils

import androidx.annotation.StringRes

data class ErrorModel(val apiError: String? = null, @StringRes val localError: Int? = null)