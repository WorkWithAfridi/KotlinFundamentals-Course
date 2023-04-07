package com.example.kotlinsharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var userName: EditText
    lateinit var userMessage: EditText
    lateinit var counter: Button
    lateinit var rememberCheckbox: CheckBox

    var count : Int = 0

    var name: String? = null
    var message: String? = null
    var isChecked: Boolean? = null

    lateinit var  sharedPreferences : SharedPreferences

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        sharedPreferences =this.getSharedPreferences(
            "mainSharedPref",
            Context.MODE_PRIVATE,
        )

        name = sharedPreferences.getString(
            "userName", "NULL"
        )
        message = sharedPreferences.getString(
            "userMessage", "NULL"
        )
        isChecked = sharedPreferences.getBoolean(
            "isChecked", false
        )
        count = sharedPreferences.getInt(
            "count", 0
        )

        userName.setText(name)
        userMessage.setText(message)
        counter.setText("${count}")
        rememberCheckbox.isChecked = isChecked!!

        Toast.makeText(
            applicationContext,
            "Your data has been restored!",
            Toast.LENGTH_LONG,
        ).show()
    }


    fun saveData(){
        sharedPreferences =this.getSharedPreferences(
            "mainSharedPref",
            Context.MODE_PRIVATE,
        )
        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = rememberCheckbox.isChecked
        val editor = sharedPreferences.edit()
        editor.putString(
            "userName", name,
        )
        editor.putString(
            "userMessage", message,
        )
        editor.putBoolean(
            "isChecked", isChecked!!,
        )
        editor.putInt(
            "count", count,
        )
        editor.apply()
        Toast.makeText(
            applicationContext,
            "Your data has been saved!",
            Toast.LENGTH_LONG,
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.userNameET)
        userMessage = findViewById(R.id.userMessageET)
        counter = findViewById(R.id.counterButton)
        rememberCheckbox = findViewById(R.id.rememberCheckbox)


        counter.setOnClickListener {
            count+=1
            counter.setText("${count.toString()}")
        }
    }
}