package ch.protonmail.android.protonmailtest.di

import ch.protonmail.android.protonmailtest.api.ApiService
import ch.protonmail.android.protonmailtest.db.ForecastDao
import ch.protonmail.android.protonmailtest.db.HottestDao
import ch.protonmail.android.protonmailtest.ui.forecast.repository.RepositoryForecast
import ch.protonmail.android.protonmailtest.ui.forecast.repository.RepositoryForecastImpl
import ch.protonmail.android.protonmailtest.ui.hottest.repository.HottestRepository
import ch.protonmail.android.protonmailtest.ui.hottest.repository.HottestRepositoryImpl
import org.koin.dsl.module

//pattern to tell Koin how to build repository module
val repositoryModule = module {

    fun provideForecastRepository(api: ApiService, dao : ForecastDao): RepositoryForecast {
        return RepositoryForecastImpl(api, dao)
    }
    fun provideHottestRepository(api: ApiService, dao : HottestDao): HottestRepository {
        return HottestRepositoryImpl(api, dao)
    }
    single { provideForecastRepository(get(), get()) }
    single { provideHottestRepository(get(), get()) }
}