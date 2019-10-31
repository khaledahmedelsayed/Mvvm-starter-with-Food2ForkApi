package com.khaled.food2fork

import android.app.Application
import com.khaled.food2fork.di.module.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppInstance : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppInstance)
            modules(Modules.appComponent)
        }
    }

}