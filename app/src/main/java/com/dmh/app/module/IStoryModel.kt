package com.dmh.app.module

/**
 * Created by dengmaohua on 2018/10/30 16:33.
 */
interface IStoryModel<T> {

    fun query(type: Int, pageSize: Int, PageIndex: Int, listener: QueryListener<T>)
}