package com.dmh.app.contract

import com.dmh.app.view.bean.Story

/**
 *@author deng
 *@date 2018/10/24 0024.
 */
interface IHomeContact {
    interface IHomeView {
        fun onLoad(data: ArrayList<Story>)
        fun onLoadMore(data: ArrayList<Story>)
    }

    /*查询接口获取数据*/
    fun query()

    /*查询接口获取更多*/
    fun queryMore()

}