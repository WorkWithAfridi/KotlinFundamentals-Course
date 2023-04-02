package com.example.kotlinintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var nameTextField :  EditText
    lateinit var ageTextField :  EditText
    lateinit var saveBtn :  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextField = findViewById(R.id.namePT)
        ageTextField = findViewById(R.id.agePT)
        saveBtn = findViewById<Button?>(R.id.saveBtn)
        saveBtn.setOnClickListener {
            val name = nameTextField.text
            val age = ageTextField.text
            if(name.isNotEmpty() && age.isNotEmpty()){

                var userDataIntent = Intent(
                    this@MainActivity,
                    UserDataActivity::class.java,
                )
                userDataIntent.putExtra(
                    "name", name.toString()
                )
                userDataIntent.putExtra(
                    "age", age.toString()
                )

                startActivity(userDataIntent)

            }else{
                Toast.makeText(this@MainActivity, "Text fields cannot be set empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}