package com.dmh.app.module

/**
 * Created by dengmaohua on 2018/10/30 16:37.
 */
interface QueryListener<T> {
    fun onSuccess(data: ArrayList<T>)
    fun onFailed(msg: String)
}