package com.dmh.app.contract

import com.dmh.app.view.bean.Author

/**
 * Created by dengmaohua on 2018/10/25 11:38.
 */
interface IFavorContact {
    interface IFavorView : BaseView {
        fun onLoad(data: ArrayList<Author>)
        fun onLoadMore(data: ArrayList<Author>)
        fun onFailed(msg: String)
        fun getType(): Int
    }

    fun queryMore()
    fun query()

}