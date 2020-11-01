package ch.protonmail.android.protonmailtest.di

import android.app.Application
import androidx.room.Room
import ch.protonmail.android.protonmailtest.db.ForecastDao
import ch.protonmail.android.protonmailtest.db.ForecastDatabase
import ch.protonmail.android.protonmailtest.db.HottestDao
import ch.protonmail.android.protonmailtest.db.HottestDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideForecastDatabase(application: Application): ForecastDatabase {
        return Room.databaseBuilder(application, ForecastDatabase::class.java, "forecast")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideForecastDao(database: ForecastDatabase): ForecastDao {
        return  database.forecastDao
    }

    fun provideHottestDatabase(application: Application): HottestDatabase {
        return Room.databaseBuilder(application, HottestDatabase::class.java, "hottest")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideHottestDao(database: HottestDatabase): HottestDao {
        return  database.hottestDao
    }

    single { provideForecastDatabase(androidApplication()) }
    single { provideForecastDao(get()) }
    single { provideHottestDatabase(androidApplication()) }
    single { provideHottestDao(get()) }
}
