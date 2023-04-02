package com.example.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class UserDataActivity : AppCompatActivity() {
    lateinit var nameTextView : TextView
    lateinit var ageTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        nameTextView = findViewById(R.id.nameTV)
        ageTextView = findViewById(R.id.ageTV)

        val name : String = intent.getStringExtra(
            "name"
        ).toString()
        val age : String = intent.getStringExtra(
            "age"
        ).toString()
        Toast.makeText(this, "name: $name & age: $age", Toast.LENGTH_SHORT).show()
        nameTextView.text = "User name is $name"
        ageTextView.text = "User age is $age"
    }
}