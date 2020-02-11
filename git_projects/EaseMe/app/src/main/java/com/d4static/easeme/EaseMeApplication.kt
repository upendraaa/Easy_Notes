package com.d4static.easeme

import android.app.Application
import com.d4static.easeme.util.Constants
import com.github.salomonbrys.kodein.*
import retrofit2.Retrofit

class EaseMeApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
    }

    override val kodein by Kodein.lazy {
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .build()
        }
        
    }
}