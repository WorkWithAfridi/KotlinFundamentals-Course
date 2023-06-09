package com.example.kotlinservices

import android.app.Service
import android.content.Intent
import android.os.IBinder

class classServicesExample : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("ClassService onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("ClassService onStartCommand")
        println("Thread: ${Thread.currentThread().name}")
//        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        println("ClassService onDestroy")
        super.onDestroy()
    }
}