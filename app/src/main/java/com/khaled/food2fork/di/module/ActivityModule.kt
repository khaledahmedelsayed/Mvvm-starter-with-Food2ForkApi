package com.khaled.food2fork.di.module

import com.khaled.food2fork.di.builder.MainActivityFragmentBuilderModule
import com.khaled.food2fork.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}