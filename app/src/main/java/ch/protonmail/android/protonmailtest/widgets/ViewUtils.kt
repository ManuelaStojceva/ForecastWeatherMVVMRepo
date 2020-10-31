package ch.protonmail.android.protonmailtest.widgets

import android.content.Context
import androidx.appcompat.app.AlertDialog
import ch.protonmail.android.protonmailtest.R

fun Context.displayInfoMsg(message: String) {
    try {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(message)
            .setPositiveButton(getString(R.string.button_text_ok)) { dialog, _ ->
                dialog.dismiss()

            }
            .setCancelable(false)
        alertDialog.setTitle(getString(R.string.app_name))
        alertDialog.show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}