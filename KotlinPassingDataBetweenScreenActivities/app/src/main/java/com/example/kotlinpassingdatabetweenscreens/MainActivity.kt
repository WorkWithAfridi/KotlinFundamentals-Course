package com.example.kotlinpassingdatabetweenscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var nameEt : TextInputEditText
    lateinit var emailEt : TextInputEditText
    lateinit var phoneEt : TextInputEditText
    lateinit var signUpBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEt = findViewById(R.id.nameET)
        emailEt = findViewById(R.id.emailET)
        phoneEt = findViewById(R.id.phoneET)
        signUpBtn = findViewById(R.id.saveBTN)

        signUpBtn.setOnClickListener {
            var userName = nameEt.text.toString()
            var userEmail = emailEt.text.toString()
            var userPhone = phoneEt.text.toString().toLong()

            val intent = Intent(
                this@MainActivity,
                SecondActivity::class.java,
            )

            intent.putExtra(
                "userName",
                userName
            )

            intent.putExtra(
                "userEmail",
                userEmail
            )

            intent.putExtra(
                "userPhone",
                userPhone
            )

            startActivity(
                intent
            )
        }
    }
}