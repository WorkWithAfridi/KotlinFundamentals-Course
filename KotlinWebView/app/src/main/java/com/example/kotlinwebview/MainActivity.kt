package com.example.kotlinwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var web: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        web = findViewById(R.id.webView)

        web.webViewClient = WebViewClient()
        web.loadUrl("https://www.google.com")

    }

    override fun onBackPressed() {
        if(web.canGoBack()){
            web.goBack()
        }else{
            super.onBackPressed()
        }
    }
}