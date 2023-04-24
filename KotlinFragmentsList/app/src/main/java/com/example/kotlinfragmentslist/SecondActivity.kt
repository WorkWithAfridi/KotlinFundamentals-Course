package com.example.kotlinfragmentslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       var position=  intent.getIntExtra("pos", 0)

        val fragmentManger : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManger.beginTransaction()

        var secondFragment = SecondFragment()

        val bundle = Bundle()

        bundle.putInt(
            "pos",
            position,
        )
        secondFragment.arguments = bundle

        fragmentTransaction.add(R.id.frameLayout, secondFragment)
        fragmentTransaction.commit()
    }
}