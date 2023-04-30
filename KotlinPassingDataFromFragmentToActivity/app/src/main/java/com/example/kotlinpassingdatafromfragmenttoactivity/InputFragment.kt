package com.example.kotlinpassingdatafromfragmenttoactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class InputFragment : Fragment() {

    lateinit var messageEditText : EditText
    lateinit var sendMessage: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        messageEditText = view.findViewById(R.id.messageInputEt)
        sendMessage = view.findViewById(R.id.sendMessageBtn)

        sendMessage.setOnClickListener {
           val mainActicity : MainActivity = activity as MainActivity
            mainActicity.getData(messageEditText.text.toString())
        }

        return  view
    }
}