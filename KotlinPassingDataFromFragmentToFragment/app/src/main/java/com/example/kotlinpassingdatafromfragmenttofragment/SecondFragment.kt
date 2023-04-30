package com.example.kotlinpassingdatafromfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {
    lateinit var messageTextView : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_second, container, false)

        messageTextView = view.findViewById(R.id.messageTv)

        messageTextView.setText(
            arguments?.getString("message") ?:
            ""
        )

        return view
    }
}