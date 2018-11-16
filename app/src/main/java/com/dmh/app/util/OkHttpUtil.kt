package com.dmh.app.util

import okhttp3.*


/**
 * Created by dengmaohua on 2018/11/16 15:19.
 */
class OkHttpUtil private constructor() {
    companion object {
        private var singleton: OkHttpClient? = null
        @Synchronized
        fun getInstance(): OkHttpClient? {
            if (singleton == null) {
                synchronized(OkHttpUtil.javaClass)
                {
                    if (singleton == null) {
                        singleton = OkHttpClient()
                    }
                }
            }
            return singleton
        }

        fun getRequest(url:String):String{
            var request=Request.Builder().url(url).build()
            var call= getInstance()?.newCall(request)
            val response = call?.execute()
            return response?.body()?.string().toString()
        }

        fun getRequest(url:String, listener: Callback){
            var request=Request.Builder().url(url).build()
            var call= getInstance()?.newCall(request)
            call?.enqueue(listener)
        }

        fun post(url:String,parames:String,listener: Callback){
            var request=Request.Builder().url(url).post(RequestBody.create( MediaType.parse("text/html; charset=utf-8"), parames)).build()
            var call= getInstance()?.newCall(request)
            call?.enqueue(listener)
        }

    }


}


