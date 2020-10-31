package ch.protonmail.android.protonmailtest.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import ch.protonmail.android.protonmailtest.R
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(context: Context) : Interceptor {
    private val appContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
            if(!isInternetAvailable()) {
                throw NoInternetException(appContext.getString(R.string.error_network_connection))
            }
            return chain.proceed(chain.request())
    }

    private fun isInternetAvailable() : Boolean{
        var result = false
       val connectivityManager =
           appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let {cm->
            cm.getNetworkCapabilities(cm.activeNetwork)?.apply {
                result = when {

                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    else -> false
                }
            }
        }
        return result
        }
    }
