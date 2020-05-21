package d4static.dev999.easynotes

import android.app.Application
import android.content.Context

class EasyNotesApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: EasyNotesApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        val context: Context = EasyNotesApplication.applicationContext()
    }
}