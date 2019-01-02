package com.dmh.app.util

import okhttp3.*
import java.io.File
import java.util.*


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

        fun getRequest(url: String): String {
            var request = Request.Builder().url(url).build()
            var call = getInstance()?.newCall(request)
            val response = call?.execute()
            return response?.body()?.string().toString()
        }

        fun getRequest(url: String, listener: Callback) {
            var request = Request.Builder().url(url).build()
            var call = getInstance()?.newCall(request)
            call?.enqueue(listener)
        }

        fun post(url: String, parames: String, listener: Callback) {
            var request = Request.Builder().url(url).post(RequestBody.create(MediaType.parse("text/html; charset=utf-8"), parames)).build()
            var call = getInstance()?.newCall(request)
            call?.enqueue(listener)
        }

        fun post(url: String, parames: Map<String, String>, listener: Callback) {
            var builder = Request.Builder().post(RequestBody.create(MediaType.parse("text/html; charset=utf-8"), "test"))
            builder.url(url)
            for (i in parames.keys) {
                builder.addHeader(i, parames.get(i))
            }
            var request =builder.build()
            var call = getInstance()?.newCall(request)
            call?.enqueue(listener)
        }


        /*
         上传文件
        fileName 文件名，
        filePath 要上传的文件路径
        listener 请求回调
         */
        fun upload(url: String, fileName: String, filePath: String, listener: Callback) {
            var requestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", fileName,
                            RequestBody.create(MediaType.parse("multipart/form-data"), File(filePath)))
                    .build()
            var request = Request.Builder()
                    .header("Authorization", "Client-ID " + UUID.randomUUID())
                    .url(url)
                    .post(requestBody)
                    .build()
            var call = getInstance()?.newCall(request)
            call?.enqueue(listener)

        }

    }


}


