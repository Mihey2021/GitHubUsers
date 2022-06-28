package com.example.githubusers.app

import android.app.Application
import androidx.room.Room
import com.example.githubusers.data.localdatabase.AppDatabase
import com.example.githubusers.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(viewModelModule, apiModule, netModule, databaseModule, repositoryModule))
        }
    }
}