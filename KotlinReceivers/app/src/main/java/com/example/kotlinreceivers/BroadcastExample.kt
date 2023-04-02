package com.example.kotlinreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastExample : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneMode : Boolean = intent!!.getBooleanExtra("state", false)
        Toast.makeText(context, "Device is on Airplane mode.", Toast.LENGTH_LONG).show()
    }
}