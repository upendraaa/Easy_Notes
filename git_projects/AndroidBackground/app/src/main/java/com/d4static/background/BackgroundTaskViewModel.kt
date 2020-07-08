package com.d4static.background

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BackgroundTaskViewModel : ViewModel() {

    fun doImmediateTask() {

        GlobalScope.launch {
            delay(1000L)
            var mul = 100 * 100;
            println("Square of 100 is " + { mul })
        }

        println("Square of 100,")

    }
}
