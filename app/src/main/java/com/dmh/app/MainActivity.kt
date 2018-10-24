package com.dmh.app

/**
 *@author deng
 *@date 2018/10/21 0021.
 */
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.dmh.app.adapter.RefreshLoadMoreListener
import com.dmh.app.adapter.StoryAdapter
import com.dmh.app.view.bean.Story
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun setData() {
        var list = ArrayList<Story>()
        for (i in 0 until 10) {
            var story = Story()
            story.title = "故事标题" + i
            if(i%2==0){
                story.type = Story.ONE_PIC_START
                story.picUrlList = ArrayList()
                story.picUrlList!!.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540233941779&di=4dbaa17b29f3e66b63624fafde0583d3&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F060828381f30e92483987f3746086e061d95f7fc.jpg")

            }
            list.add(story)
        }
//        list[0].type = Story.ONE_PIC_START
//        list[0].picUrlList = ArrayList()
//        list[0].picUrlList!!.add("https://sjbz-fd.zol-img.com.cn/t_s320x510c/g5/M00/09/0C/ChMkJluJNc6IEocxAA242Pyd4qUAArXegMtSfoADbjw777.jpg")
//
//        list[1].type = Story.ONE_PIC_START
//        list[1].picUrlList = ArrayList()
//        list[1].picUrlList!!.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540233941779&di=4dbaa17b29f3e66b63624fafde0583d3&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F060828381f30e92483987f3746086e061d95f7fc.jpg")

        var adapter = StoryAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RefreshLoadMoreListener() {
            override fun onLoadMore() {
                adapter.addMore(getMoreData())
            }
        })
    }

    fun getMoreData(): ArrayList<Story> {
        var list = ArrayList<Story>()
        var count = recyclerView.adapter.itemCount;
        for (i in 0 until 10) {
            var story = Story()
            story.title = "故事标题" + (count + i)
            list.add(story)
        }
        return list;
    }
}

