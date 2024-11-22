package com.example.pmdmsimul.app

import android.app.Application
import com.example.pmdmsimul.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


class ItemAplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@ItemAplication)
            modules(AppModule().module)
        }
    }
}