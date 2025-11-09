package com.qrife

import android.Manifest
import android.os.Bundle
import android.webkit.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var web: WebView

    private val askCamera =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web = WebView(this)
        setContentView(web)

        val ws = web.settings
        ws.javaScriptEnabled = true
        ws.domStorageEnabled = true
        ws.allowFileAccess = true
        ws.allowContentAccess = true
        ws.mediaPlaybackRequiresUserGesture = false

        web.webViewClient = object : WebViewClient() {}
        web.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                runOnUiThread {
                    askCamera.launch(Manifest.permission.CAMERA)
                    request.grant(request.resources)
                }
            }
        }

        // Lädt die HTML-Datei aus dem assets-Ordner:
        web.loadUrl("file:///android_asset/index.html")
    }

    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack()
        else super.onBackPressed()
    }
}
