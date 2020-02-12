package com.d4static.easeme

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.d4static.easeme.util.Constants
import com.github.salomonbrys.kodein.*
import com.payoda.kotlindemo.database.ApplicationDatabase
import retrofit2.Retrofit

class EaseMeApplication : Application(), KodeinAware {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
    }

    override val kodein by Kodein.lazy {
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .build()
        }

        bind<ApplicationDatabase>() with singleton {
            Room.databaseBuilder(
                this@EaseMeApplication,
                ApplicationDatabase::class.java,
                "easeme_db"
            )
                .allowMainThreadQueries()
                .build()
        }


    }
}