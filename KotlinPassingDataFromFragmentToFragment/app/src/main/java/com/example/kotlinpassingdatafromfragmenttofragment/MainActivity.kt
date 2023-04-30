package com.example.kotlinpassingdatafromfragmenttofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()

        var firstFragment = FirstFragment()

        fragmentTransaction.add(R.id.fragmentFrame, firstFragment).commit()
    }
}