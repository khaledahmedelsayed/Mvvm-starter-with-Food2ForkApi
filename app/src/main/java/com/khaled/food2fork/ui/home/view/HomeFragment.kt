package com.khaled.food2fork.ui.home.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.food2fork.R
import com.khaled.food2fork.ui.base.BaseFragment
import com.khaled.food2fork.ui.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_main
    }

    override fun onViewReady() {
        setRecyclerView()
        viewModel.buildResponseList() //For some reason responseList must be built before observing on it ,
        // otherwise create() in FoodDataSourceFactory won't be called
        setObservers()
    }

    private fun setObservers() {
        viewModel.responseList.observe(this, Observer {
            (this.rvFoodList.adapter as FoodListAdapter).submitList(it)
        })
    }

    private fun setRecyclerView() {
        val mRecyclerView = this.rvFoodList
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = FoodListAdapter()
        }
    }
}