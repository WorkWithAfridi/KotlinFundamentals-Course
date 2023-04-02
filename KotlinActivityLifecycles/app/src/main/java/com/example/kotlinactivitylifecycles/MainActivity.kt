package com.example.kotlinactivitylifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       println(
            "onCreate"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
       println(
            "onDestroy"
        )
    }

    override fun onPause() {
        super.onPause()
       println(
            "onPause"
        )
    }

    override fun onStop() {
        super.onStop()
       println(
            "onStop"
        )
    }

    override fun onStart() {
        super.onStart()
       println(
            "onStart"
        )
    }

    override fun onResume() {
        super.onResume()
       println(
            "onResume"
        )
    }

    override fun onRestart() {
        super.onRestart()
       println(
            "onRestart"
        )
    }
}