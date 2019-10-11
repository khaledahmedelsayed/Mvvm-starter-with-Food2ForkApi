package com.hemdan.mvvm.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hemdan.mvvm.R
import com.hemdan.mvvm.data.model.Recipe
import com.hemdan.mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    private var recipesList: ArrayList<Recipe?> = ArrayList()

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_main
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        setRecyclerView()
        setObservers()
        viewModel.loadFoodList()
    }

    private fun setObservers() {
        viewModel.responseList.observe(this, Observer {
            recipesList.addAll(it)
            rv_food_list.adapter?.notifyItemRangeChanged(rv_food_list.adapter!!.itemCount, it.size)
        })    }

    private fun setRecyclerView() {
        val mRecyclerView = this.rv_food_list
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = FoodListAdapter(recipesList)
        }    }
}
