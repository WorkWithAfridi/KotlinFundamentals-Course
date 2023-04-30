package com.example.kotlinpassingdatafromfragmenttoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var message : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.messageTv)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val inputFragment = InputFragment()

        fragmentTransaction.add(R.id.fragmentFrame, inputFragment,)
        fragmentTransaction.commit()
    }

    fun getData(msg: String){
        message.text = msg
    }


}