package com.dmh.app.view.bean

import java.io.Serializable

/**
 *@Author deng
 *@date 2018/10/29 0029.
 */
class Author : Serializable {
    /*用户名*/
    var name: String? = ""
    /*用户ID*/
    var id: String? = ""
    /*作品数*/
    var works: Int = 0
    /*关注他的人数*/
    var follow: Int = 0
}