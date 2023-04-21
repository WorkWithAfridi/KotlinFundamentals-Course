package com.example.kotlinfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var firstBtn : Button
    lateinit var secondBtn : Button
    lateinit var moveToSecondActivity : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstBtn = findViewById(R.id.fragOneBtn)
        secondBtn = findViewById(R.id.fragTwoBtn)

        val fragmentManifest : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManifest.beginTransaction()

        moveToSecondActivity = findViewById(R.id.moveToSecondActivityBtn)

        moveToSecondActivity.setOnClickListener {
            startActivity(
                Intent(
                    this, SecondActivity::class.java
                )
            )
            finish()
        }



        val firstFragment = FirstFragment()
        fragmentTransaction.add(
            R.id.frame,
            firstFragment,
        )

        fragmentTransaction.commit()

        secondBtn.setOnClickListener {
            val secondFragmentManager : FragmentManager = supportFragmentManager
            val secondFragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()
            secondFragmentTransaction.replace(
                R.id.frame,
                secondFragment,
            )


            ///To add fragment in stack
            secondFragmentTransaction.addToBackStack(
                null,
            )

            secondFragmentTransaction.commit()
        }

        firstBtn.setOnClickListener {

            val fragmentManifest1 : FragmentManager = supportFragmentManager
            val fragmentTransaction1 : FragmentTransaction = fragmentManifest1.beginTransaction()

            val firstFragment1 = FirstFragment()
            fragmentTransaction1.replace(
                R.id.frame,
                firstFragment,
            )

            fragmentTransaction1.commit()
        }
    }
}