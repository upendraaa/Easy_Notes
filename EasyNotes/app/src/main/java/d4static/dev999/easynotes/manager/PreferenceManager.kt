package d4static.dev999.easynotes.manager

import android.content.Context
import android.content.SharedPreferences
import d4static.dev999.easynotes.EasyNotesApplication

object PreferenceManager {
    private const val sharedPrefFile = "easynotespref"
    public const val USER_ID = "uid"
    const val EMAIL_ID = "emailId"
    const val MOBILE_NUMBER = "mobileNumber"


    lateinit var preference: SharedPreferences
    lateinit var context: Context

    fun getPreference(): PreferenceManager {

        context = EasyNotesApplication.applicationContext()
        preference = context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);


        return PreferenceManager;
    }

    fun setData(key: String, value: Any?) {

        val editor = preference.edit();
        if (value == null) {
            editor.putString(key, value)

        } else if (value is String) {
            editor.putString(key, value)

        } else if (value is Int) {
            editor.putInt(key, value)

        } else if (value is Boolean) {
            editor.putBoolean(key, value)

        } else if (value is Double) {
            editor.putFloat(key, value as Float)

        }

        editor.commit();

    }

    fun getData(key: String, obj: Any, defaultValue: Any): Any {

        if (obj is Int) {
            return preference.getInt(key, defaultValue as Int) as Any

        } else if (obj is Boolean) {
            return preference.getBoolean(key, defaultValue as Boolean) as Any

        } else if (obj is Double) {
            return preference.getFloat(key, defaultValue as Float)

        } else {
            return preference.getString(key, defaultValue as String) as Any

        }
    }


}