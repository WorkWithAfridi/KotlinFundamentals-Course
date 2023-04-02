package com.example.kotlinservices

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService

class JobIntentServiceExample : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        println(
            "JobIntentService onHandleWork : Service started"
        )
        println("Thread: ${Thread.currentThread().name}")
    }

    companion object{
        fun myBackgroundService(context: Context, intent: Intent){
            enqueueWork(
                context,
                JobIntentServiceExample::class.java,
                11,
                intent,
            )
        }
    }

    override fun onDestroy() {
        println(
            "JobIntentService onDestroy called"
        )
        super.onDestroy()
    }
}