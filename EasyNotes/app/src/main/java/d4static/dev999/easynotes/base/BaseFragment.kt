package d4static.dev999.easynotes.base

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import d4static.dev999.easynotes.R
import kotlinx.android.synthetic.main.layout_appbar.*


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

    open fun onPositiveClick(view: View, obj: Any) {

    }

    open fun onNegativeClick(view: View, obj: Any) {

    }

    fun showView(view: View) {
        view.visibility = View.VISIBLE
    }

    fun hideView(view: View) {
        view.visibility = View.GONE
    }

    fun enableView(view: View) {
        view.visibility = View.VISIBLE
    }

    fun disableView(view: View) {
        view.visibility = View.GONE
    }

    fun showToolbar() {
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
    }

    fun hideToolbar() {
        (activity as AppCompatActivity?)!!.setSupportActionBar(null)
    }

    fun navigate(view: View, fragmentId: Int) {
        val navController = view?.let { Navigation.findNavController(it) }
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_out_top)
            .setPopEnterAnim(R.anim.slide_out_top)
            .setExitAnim(R.anim.slide_in_top)
            .setPopExitAnim(R.anim.slide_in_top)
            .build()
        navController!!.navigate(fragmentId, null, navOptions)
    }


}