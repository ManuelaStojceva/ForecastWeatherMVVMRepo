package ch.protonmail.android.protonmailtest.di

import android.app.Application
import androidx.room.Room
import ch.protonmail.android.protonmailtest.db.ForecastDao
import ch.protonmail.android.protonmailtest.db.ForecastDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): ForecastDatabase {
        return Room.databaseBuilder(application, ForecastDatabase::class.java, "forecast")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideForecastDao(database: ForecastDatabase): ForecastDao {
        return  database.forecastDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideForecastDao(get()) }
}
