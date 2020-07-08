package com.d4static.background

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BackgroundTaskViewModel : ViewModel() {

    fun doImmediateTask() {

        //Global scope is like demon thread for co-routines
        GlobalScope.launch {
            delay(1000L)
            var mul = 100 * 100;
            println("Square of 100 is " + { mul })
        }

        println("Square of 100,")

    }

    //Launching 10K coroutines
    fun repeatDot() = runBlocking {
        repeat(10_000) {
            launch {
                delay(100L)
                print(".")
            }
        }
    }
}
