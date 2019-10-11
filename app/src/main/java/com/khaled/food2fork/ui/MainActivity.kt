package com.khaled.food2fork.ui

import android.os.Bundle
import com.khaled.food2fork.R
import com.khaled.food2fork.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}