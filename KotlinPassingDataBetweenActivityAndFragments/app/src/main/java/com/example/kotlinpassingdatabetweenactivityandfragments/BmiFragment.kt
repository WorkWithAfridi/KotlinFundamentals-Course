package com.example.kotlinpassingdatabetweenactivityandfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BmiFragment : Fragment() {

    lateinit var result : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_bmi, container, false)

        result = view.findViewById(R.id.resultTv)

        var weight = requireArguments().getInt("weight", 0 )
        var height = requireArguments().getInt("height", 0)

        var bmi = ((weight*10000)/(height*height)).toDouble()

        result.text = "Your BMI is ${bmi}"

        return view
    }
}