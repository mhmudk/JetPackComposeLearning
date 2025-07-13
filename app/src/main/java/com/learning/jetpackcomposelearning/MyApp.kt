package com.learning.jetpackcomposelearning

import android.app.Application
import com.learning.jetpackcomposelearning.di.LocalDB
import com.learning.jetpackcomposelearning.di.RemoteApiService
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val appModule = module {
            single {RemoteApiService(get())}
            single {LocalDB()}
        }



        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}