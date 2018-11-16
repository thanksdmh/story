package com.dmh.app.net

import android.util.Log
import okhttp3.Call
import java.io.IOException


/**
 * Created by dengmaohua on 2018/11/16 15:44.
 */
abstract class BaseCallback : okhttp3.Callback {
    override fun onFailure(call: Call?, e: IOException?) {
        Log.e("okTest", e?.message)
    }
}