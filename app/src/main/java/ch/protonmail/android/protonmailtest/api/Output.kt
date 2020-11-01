package ch.protonmail.android.protonmailtest.api

import java.io.IOException

/*
  sealed class to handle network response. It can either be a success with the results coming with it or failure with an exception.
 */
sealed class Output<out T : Any>{
    data class Success<out T : Any>(val output : T) : Output<T>()
    data class Error(val exception: IOException)  : Output<Nothing>()
}