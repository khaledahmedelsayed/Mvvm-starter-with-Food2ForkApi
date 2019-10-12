package com.khaled.food2fork.ui.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.food2fork.R
import com.khaled.food2fork.ui.base.BaseFragment
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