package com.hemdan.mvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hemdan.mvvm.di.helper.Injectable

/**
 * Created by Mohammed Hemdan on 4/14/19.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
abstract class BaseFragment : Fragment(), Injectable {
    abstract fun onViewReady(savedInstanceState: Bundle?)
    abstract fun getLayoutResourceId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onViewReady(savedInstanceState)
    }

}