package com.example.kotlinpassingdatabetweenscreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var email : TextView
    lateinit var phone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        name = findViewById(R.id.nameTv)
        email = findViewById(R.id.emailTv)
        phone = findViewById(R.id.phoneTv)
        name.setText("Your display name is "+intent.getStringExtra("userName"),)
        email.setText("Your display email is "+intent.getStringExtra("userEmail"),)
        phone.setText("Your display phone number is "+intent.getLongExtra("userPhone", 0),)
    }
}