package com.example.libstoriespoc

import android.app.Application
import com.example.libstoriespoc.di.Inject.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


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