package com.example.libstoriespoc

import android.app.Application
import com.example.libstoriespoc.di.Inject.appModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class StartKoinAp : Application() {

    override fun onCreate() {

        super.onCreate()


        startKoin{

            androidLogger()

            androidContext(this@StartKoinAp)

            modules(listOf(appModule))

        }

    }


    override fun onTerminate() {

        super.onTerminate()

        stopKoin()

    }

}