package com.example.kotlinfragmentdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class DialogFragment : androidx.fragment.app.DialogFragment() {
    lateinit var name : EditText
    lateinit var age : EditText
    lateinit var cancel : Button
    lateinit var ok : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_dialog, container, false)
        name = view.findViewById(R.id.NameET)
        age = view.findViewById(R.id.ageET)
        cancel = view.findViewById(R.id.cancelBTN)
        ok = view.findViewById(R.id.okBTN)

        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        ok.setOnClickListener {
            var userName = name.text.toString()
            var userAge = age.text.toString()

            val mainActivity : MainActivity = activity as MainActivity
            mainActivity.getUserData(userName, userAge)

            dialog!!.dismiss()
        }
        cancel.setOnClickListener {
            dialog!!.dismiss()
        }



        return view
    }
}