package com.example.kotlinfragmentslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    lateinit var countryNameTv : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_second, container, false)

        countryNameTv = view.findViewById(R.id.countryNameTV)

        var position = arguments?.getInt("pos")

        val stringArray = getResources().getStringArray(R.array.countries);

        countryNameTv.setText(
            stringArray[position!!]
        )

        // Inflate the layout for this fragment
        return view

    }
}