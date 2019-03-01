package tk.merith.devdocs

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*
import android.webkit.WebSettings
import android.webkit.WebStorage
import android.webkit.WebChromeClient





class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_webview)

        val mWebView = findViewById<WebView>(R.id.webview)

        val webSettings = mWebView.settings
//begin custom crap

        mWebView.setWebChromeClient(object : WebChromeClient() {
            override fun onReachedMaxAppCacheSize(spaceNeeded: Long, totalUsedQuota: Long,
                                                  quotaUpdater: WebStorage.QuotaUpdater) {
                quotaUpdater.updateQuota(spaceNeeded * 2)
            }
        })

        mWebView.getSettings().setDomStorageEnabled(true)

// Set cache size to 8 mb by default. should be more than enough
        mWebView.getSettings().setAppCacheMaxSize(1024 * 1024 * 512)

// This next one is crazy. It's the DEFAULT location for your app's cache
// But it didn't work for me without this line.
// UPDATE: no hardcoded path. Thanks to Kevin Hawkins
        val appCachePath = applicationContext.cacheDir.absolutePath
        mWebView.getSettings().setAppCachePath(appCachePath)
        mWebView.getSettings().setAllowFileAccess(true)
        mWebView.getSettings().setAppCacheEnabled(true)

//end custom crap
        webSettings.javaScriptEnabled = true
        mWebView.loadUrl(getString(R.string.website_url))
        mWebView.webViewClient = HelloWebViewClient()
        WebView.setWebContentsDebuggingEnabled(false)
        webview.getSettings().setUserAgentString("Merith-TK InAppBrowser");


    }

    private inner class HelloWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (Uri.parse(url).host == getString(R.string.website_domain)) {
                return false
            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    // TODO Configure AppCache
}
