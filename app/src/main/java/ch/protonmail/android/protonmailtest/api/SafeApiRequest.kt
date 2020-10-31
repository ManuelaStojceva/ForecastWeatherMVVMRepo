package ch.protonmail.android.protonmailtest.api

import android.util.Log
import okio.IOException
import retrofit2.Response

/*
Class to handle the safe API calls
-two suspending higher-order functions. Both take a suspending function that returns a response
and an error message that will be displayed when an error occurs.
 */
abstract class SafeApiRequest {
    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) :  T?{
        val result = handleApiOutput(call, error)
        var output : T? = null
        when(result){
            is Output.Success ->
                output = result.output
            is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }

    private suspend fun<T : Any> handleApiOutput(call: suspend()-> Response<T>, error: String) : Output<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Output.Success(response.body()!!)
        else
            Output.Error(IOException("Something went wrong due to  $error"))
    }
}