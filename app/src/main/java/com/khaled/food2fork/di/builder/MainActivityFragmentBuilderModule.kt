package com.khaled.food2fork.di.builder

import com.khaled.food2fork.ui.home.view.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): HomeFragment
}