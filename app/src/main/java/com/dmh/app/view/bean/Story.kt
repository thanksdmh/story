package com.dmh.app.view.bean

import java.io.Serializable

/**
 *@author deng
 *@date 2018/10/21 0021.
 */
class Story :Serializable {
    companion object {
        /*加载更多*/
        const val LOAD_MORE = -1
        /*无图片仅仅只有标题*/
        const val SIMPLE = 1
        /*简介前有图片开始*/
        const val ONE_PIC_START = 2
        /*简介前后有一张图片*/
        const val ONE_PIC_END = 3
        /*有超过两张图片在文章简介下*/
        const val MORE_PIC_BELOWN = 4
    }

    //类型
    var type: Int = 0
    //标题
    var title: String? = ""
    //作者
    var author: String? = ""
    //内容
    var content: String? = ""
    /*简介*/
    var introduce: String? = ""
    /*图片地址*/
    var picUrlList: ArrayList<String>? = null
}