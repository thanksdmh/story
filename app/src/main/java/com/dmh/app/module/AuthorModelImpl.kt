package com.dmh.app.module

import com.dmh.app.view.bean.Author
import java.util.*

/**
 *@author deng
 *@date 2018/10/30 0030.
 */
class AuthorModelImpl : IAuthorModel {
    override fun query(type: Int, listener: QueryListener<Author>) {
        val t = Thread({
            Thread.sleep(2000)
            println("C 使用 Lambda 表达式:${Thread.currentThread()}")

            var list = ArrayList<Author>()
            for (i in 0 until 10) {
                var author = Author()
                author.follow = Random().nextInt(1000)
                author.name = "张少" + i
                author.id = UUID.randomUUID().toString()
                author.works = Random().nextInt(100)
                list.add(author)
            }
            listener.onSuccess(list)
        })
        t.start()
    }


}