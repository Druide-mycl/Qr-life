package com.qrife

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        setContentView(web)

        // 1) Test: zeigt Text -> App startet sicher
        web.loadData("<h2 style='font-family:sans-serif'>QR Life läuft ✅</h2>",
            "text/html","utf-8")

        // Wenn das läuft, nächste APK bauen und danach diese Zeile aktivieren:
        // web.loadUrl("file:///android_asset/index.html")
    }
}
