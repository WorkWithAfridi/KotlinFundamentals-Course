package com.example.kotlinmultilangsupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var helloTV : TextView
    lateinit var showToastBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTV = findViewById(R.id.helloWorldTv)
        showToastBtn = findViewById(R.id.showToastBtn)

        showToastBtn.setOnClickListener {
            Toast.makeText(this, R.string.toast_msg, Toast.LENGTH_LONG).show()
        }
    }
}