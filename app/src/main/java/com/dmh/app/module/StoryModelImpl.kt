package com.dmh.app.module

import android.util.Log
import com.dmh.app.GetStoryList
import com.dmh.app.net.BaseCallback
import com.dmh.app.util.OkHttpUtil
import com.dmh.app.view.bean.Story
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Response
import org.json.JSONObject

/**
 * Created by dengmaohua on 2018/10/30 16:39.
 */
class StoryModelImpl : IStoryModel<Story> {
    override fun query(type: Int, listener: QueryListener<Story>) {
        var obj= JSONObject()
        obj.put("type","1")
        obj.put("pageSize","10")
        obj.put("pageIndex","1")
        OkHttpUtil.post(GetStoryList,obj.toString(),object : BaseCallback() {

            override fun onResponse(call: Call?, response: Response?) {
               Log.e("okTest", response?.body()?.string())
                listener.onSuccess(Gson().fromJson(response?.body()?.string(), object : TypeToken<ArrayList<Story>>() {}
                        .type))
            }

        })
//        val t = Thread({
//            Thread.sleep(2000)
//            println("C 使用 Lambda 表达式:${Thread.currentThread()}")
//
//            var list = ArrayList<Story>()
//            for (i in 0 until 10) {
//                var story = Story()
//                story.title = "故事标题" + i
//                if (i % 2 == 0 && type == 0) {
//                    story.type = Story.ONE_PIC_START
//                    story.picUrlList = ArrayList()
//                    story.picUrlList!!.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540233941779&di=4dbaa17b29f3e66b63624fafde0583d3&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F060828381f30e92483987f3746086e061d95f7fc.jpg")
//
//                }
//                story.story_context = "公司招聘新工人，小李前来应聘。\n" +
//                        "招办主任：想到我们公司来工作，必须肯吃苦，你能吃苦吗？\n" +
//                        "小李：我绝对能吃苦。\n" +
//                        "招办主任：你都能吃怎样的苦？\n" +
//                        "小李：苦瓜我一口气吃五根都不成问题，就是黄连我都能喝一大碗。怎么样？\n" +
//                        "招办主任：卧槽"
//                list.add(story)
//                listener.onSuccess(list)
//            }
//        })
//        t.start()
    }

}