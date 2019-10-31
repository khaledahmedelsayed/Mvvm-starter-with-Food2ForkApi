package com.khaled.food2fork.ui.home.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.food2fork.R
import com.khaled.food2fork.ui.base.BaseFragment
import com.khaled.food2fork.ui.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    override val viewModel by viewModel(HomeViewModel::class)

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_main
    }

    override fun onViewReady() {
        setRecyclerView()
        setObservers()
        viewModel.loadFoodList()
    }

    private fun setObservers() {
        viewModel.responseList.observe(this, Observer {
            val foodListAdapter = (rvFoodList.adapter as FoodListAdapter)
            foodListAdapter.insertList(it)
            foodListAdapter.notifyItemRangeChanged(foodListAdapter.itemCount, it.size)
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