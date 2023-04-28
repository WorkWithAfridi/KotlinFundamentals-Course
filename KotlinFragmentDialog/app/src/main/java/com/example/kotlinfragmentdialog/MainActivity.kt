package com.example.kotlinfragmentdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    lateinit var nameTv : TextView
    lateinit var ageTv : TextView
    lateinit var showDialogBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTv = findViewById(R.id.tv1)
        ageTv = findViewById(R.id.tv2)

        showDialogBtn = findViewById(R.id.showDialogBTN)

        showDialogBtn.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager
            val dialogFragment : DialogFragment = DialogFragment()

            dialogFragment.isCancelable = false

            dialogFragment.show(
                fragmentManager,
                "DialogFragment"
            )
        }
    }

    fun getUserData(userName : String, userAge: String){
        nameTv.setText(userName)
        ageTv.setText(userAge)
    }
}