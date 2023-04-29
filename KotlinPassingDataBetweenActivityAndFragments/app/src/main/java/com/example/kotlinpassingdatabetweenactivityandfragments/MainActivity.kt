package com.example.kotlinpassingdatabetweenactivityandfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var etWeight  : EditText
    lateinit var etHeight : EditText
    lateinit var calculate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.weightEt)
        etHeight = findViewById(R.id.heightEt)
        calculate = findViewById(R.id.calculateBtn)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val bmiFragment = BmiFragment()

        calculate.setOnClickListener {
            val weight = etWeight.text.toString().toInt()
            val height = etHeight.text.toString().toInt()

            val bundle=Bundle()
            bundle.putInt(
                "weight" , weight
            )
            bundle.putInt(
                "height", height
            )

            bmiFragment.arguments = bundle

            fragmentTransaction.add(R.id.frame, bmiFragment,)
            fragmentTransaction.commit()
        }
    }
}