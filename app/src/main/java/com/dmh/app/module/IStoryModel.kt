package com.dmh.app.module

/**
 * Created by dengmaohua on 2018/10/30 16:33.
 */
interface IStoryModel<T> {

    fun query(listener: QueryListener<T>)
}