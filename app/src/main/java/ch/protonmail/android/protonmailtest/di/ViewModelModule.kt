package ch.protonmail.android.protonmailtest.di

import ch.protonmail.android.protonmailtest.ui.forecast.ViewModelForecast
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build ViewModel
    viewModel {
        ViewModelForecast(
            repository = get()
        )
    }
}