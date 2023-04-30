package com.example.kotlinsendsms

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    lateinit var phoneNumber : EditText
    lateinit var message : EditText
    lateinit var sendBtn : Button

    lateinit var userPhhone : String
    lateinit var userMessage : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneNumber = findViewById(R.id.phoneEt)
        message = findViewById(R.id.messageEt)
        sendBtn = findViewById(R.id.sendSmsBtn)

        sendBtn.setOnClickListener {
            userMessage = message.text.toString()
            userPhhone = phoneNumber.text.toString()
            sendMessage(userMessage, userPhhone)
        }
    }

    fun sendMessage(msg: String, num : String){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS, )!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 1)
        }else{
            val smsManager : SmsManager
            if(Build.VERSION.SDK_INT>=23){
                 smsManager = this.getSystemService(SmsManager::class.java)
            }else{
                smsManager = SmsManager.getDefault()
            }
            smsManager.sendTextMessage(
                num,
                null,
                msg,
                null,
                null,
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1 && grantResults.size>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
            val smsManager : SmsManager
            if(Build.VERSION.SDK_INT>=23){
                smsManager = this.getSystemService(SmsManager::class.java)
            }else{
                smsManager = SmsManager.getDefault()
            }
            smsManager.sendTextMessage(
                userPhhone,
                null,
                userMessage,
                null,
                null,
            )
            Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show()
        }
    }
}