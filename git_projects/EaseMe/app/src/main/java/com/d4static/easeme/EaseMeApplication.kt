package com.d4static.easeme

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

class EaseMeApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
    }

    override val kodein by Kodein.lazy {

    }
}