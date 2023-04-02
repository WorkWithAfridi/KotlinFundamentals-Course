package com.example.kotlinservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var classicServiceBtn: Button
    lateinit var jobIntentServiceBtn: Button
    lateinit var stopServiceBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        classicServiceBtn = findViewById(R.id.classicServiceBtn)
        jobIntentServiceBtn = findViewById(R.id.jobIntentServiceBtn)
        stopServiceBtn = findViewById(R.id.stopServiceBtn)

        classicServiceBtn.setOnClickListener {
            //Uses main thread
            val intent = Intent(
                this@MainActivity,
                classServicesExample::class.java,
            )
            startService(intent)
        }
        jobIntentServiceBtn.setOnClickListener {
            //uses its own thread
            var intent = Intent(
                this@MainActivity,
                JobIntentServiceExample::class.java,
            )

            JobIntentServiceExample.myBackgroundService(this@MainActivity, intent)
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                classServicesExample::class.java,
            )
            stopService(intent)
        }
    }
}