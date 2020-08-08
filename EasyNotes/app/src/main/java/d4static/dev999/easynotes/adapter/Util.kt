package d4static.dev999.easynotes.adapter

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class Util {

    @SuppressLint("SimpleDateFormat")
    fun convertLongToDateString(systemTime: Long): String {
        return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
    }

}