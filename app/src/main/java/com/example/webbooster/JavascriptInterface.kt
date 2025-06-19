package com.example.webbooster

import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.annotation.MainThread
import org.json.JSONObject

class JavascriptInterface(private val webView: WebView) {

    @JavascriptInterface
    fun sendMessage(message: String) {
        Log.d("message_user", "get $message")

        try {
            val json = JSONObject(message)
            val type = json.optString("type")
            if (type == "page") {
                val name = json.optString("name")
                Log.d("load", name)

                val pageUrl = "file:///android_asset/$name.html"

                webView.post {
                    webView.loadUrl(pageUrl)
                }

                return
            } else {
                Log.d("message_user", "Type != page, пропускаємо")
            }
        } catch (e: Exception) {
            Log.e("message_user", "Помилка парсингу JSON: ${e.message}")
        }

        webView.post {
            webView.evaluateJavascript(
                "javascript:showResponse('Привіт, Kotlin отримав: $message');",
                null
            )
        }
    }
}
