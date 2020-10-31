package ch.protonmail.android.protonmailtest.di

import ch.protonmail.android.protonmailtest.api.ApiService
import ch.protonmail.android.protonmailtest.db.ForecastDao
import ch.protonmail.android.protonmailtest.ui.repository.RepositoryForecast
import ch.protonmail.android.protonmailtest.ui.repository.RepositoryForecastImpl
import org.koin.dsl.module

//pattern to tell Koin how to build repository module
val repositoryModule = module {

    fun provideForecastRepository(api: ApiService, dao : ForecastDao): RepositoryForecast {
        return RepositoryForecastImpl(api, dao)
    }
    single { provideForecastRepository(get(), get()) }

}