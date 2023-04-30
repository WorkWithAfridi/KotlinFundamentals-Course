package com.example.kotlinpassingdatafromfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FirstFragment : Fragment() {
    lateinit var messageEditText : EditText
    lateinit var sendButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view  = inflater.inflate(R.layout.fragment_first, container, false)

        messageEditText = view.findViewById(R.id.messageEt)
        sendButton = view.findViewById(R.id.sendBtn)

        sendButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("message", messageEditText.text.toString())
            var secondFragment = SecondFragment()
            secondFragment.arguments=bundle

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragmentFrame, secondFragment,).commit()
        }

        return view
    }
}