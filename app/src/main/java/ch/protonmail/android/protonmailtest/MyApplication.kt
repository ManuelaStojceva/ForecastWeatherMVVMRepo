package ch.protonmail.android.protonmailtest

import android.app.Application
import ch.protonmail.android.protonmailtest.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(interceptorModule,networkModule, databaseModule, repositoryModule, viewModelModule)
        }
    }
}