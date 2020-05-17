package d4static.dev999.easynotes.callback

import android.view.View

interface OnItemClickListener {

    fun onItemClick(obj: Any?, view: View?)
    fun onLongClick(obj: Any?, view: View?)
    fun onItemSelected(obj: Any?, view: View?)
}