package com.ant.happy

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                getInfo()
//                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    val handle = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            msg.let {
                val msgtmp = msg?.obj
                webView.loadUrl(msgtmp.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView.settings.javaScriptEnabled=true
        webView.webViewClient = object: WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, url)
            }
        }

        //请求链接
        getInfo()
    }

    fun getInfo() {

        Thread(object : Runnable {
            override fun run() {
                var result = OkHttpUtil.getRequest("http://677029.com/getAppConfig.php?appid=wode3539")
                if (result.contains("true")) {
                    val msg = Message()
                    msg.obj = getUrl(result)
                    handle.sendMessage(msg)
                }
            }
        }).start()
    }

    private fun getUrl(result: String): String {
        if (TextUtils.isEmpty(result)) {
            return ""
        } else {
            val bean = Gson().fromJson<ResultBean>(result,ResultBean::class.java)
            return bean.Url
        }

    }
}
