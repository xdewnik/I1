package com.coolya.i1

import android.app.Application
import com.coolya.i1.room.DBModule
import com.coolya.i1.ui.main.di.CreateModule
import com.coolya.i1.ui.main.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    MainModule,
                    DBModule,
                    CreateModule
                )
            )
        }

        Timber.plant(Timber.DebugTree())
    }
}