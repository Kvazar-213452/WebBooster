package com.example.webbooster

import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("start", "start app")

        super.onCreate(savedInstanceState)
        webView = WebView(this)
        setContentView(webView)

        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        webView.addJavascriptInterface(JavascriptInterface(webView), "Android")

        webView.loadUrl("file:///android_asset/index.html")
    }
}
