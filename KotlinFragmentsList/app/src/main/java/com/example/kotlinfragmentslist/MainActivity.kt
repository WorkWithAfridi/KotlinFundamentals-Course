package com.example.kotlinfragmentslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManger : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManger.beginTransaction()

        val myListFragment = MyListFragment()

        fragmentTransaction.add(R.id.frameOne, myListFragment,)

        fragmentTransaction.commit()
    }
}