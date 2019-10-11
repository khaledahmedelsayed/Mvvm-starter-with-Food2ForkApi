package com.khaled.food2fork.di.module

import com.khaled.food2fork.di.builder.MainActivityFragmentBuilderModule
import com.khaled.food2fork.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mohammed Hemdan on 4/14/19.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}