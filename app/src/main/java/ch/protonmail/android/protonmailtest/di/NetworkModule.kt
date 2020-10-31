package ch.protonmail.android.protonmailtest.di

import ch.protonmail.android.protonmailtest.BuildConfig
import ch.protonmail.android.protonmailtest.api.ApiService
import ch.protonmail.android.protonmailtest.api.NetworkConnectionInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

//pattern to tell Koin how to build network module
val networkModule = module {

    fun getOkHttpClient(httpLoggingInterceptor: NetworkConnectionInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): ApiService {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient(networkConnectionInterceptor))
            .build().create(ApiService::class.java)
    }


    single { getOkHttpClient(get()) }
    single {
        invoke(get())
    }
}
val interceptorModule = module {

    single { NetworkConnectionInterceptor(androidContext()) }
}