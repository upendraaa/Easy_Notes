package d4static.dev999.easynotes.base

import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {


    lateinit var alertDialog: AlertDialog
    lateinit var progressBar: ProgressBar


    fun showProgresssBar() {
        progressBar = ProgressBar(context)

    }

    fun stopProgressBar() {
    }

    fun initializeAlertDialog(
        title: String, message: String, positiveButton: String,
        negativeButton: String, isCancelable: Boolean
    ) {


    }

    fun dismissDialog() {
        if (alertDialog != null && alertDialog.isShowing) {
            alertDialog.dismiss()
        }
    }

}