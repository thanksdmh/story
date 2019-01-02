package com.dmh.app.fragment

import android.os.Bundle
import android.view.View
import com.dmh.app.R
import com.dmh.app.contract.IMineContact
import com.dmh.app.contract.MinePresenter
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * 个人中心
 * Created by dengmaohua on 2018/10/23 16:20.
 * 我的收藏
 * 喜欢的作者
 * 我的文章
 */
class MineFragment : BaseContactFragment<IMineContact.IMineView, MinePresenter>(), IMineContact.IMineView {
    override fun createPresenter(): MinePresenter {
        return MinePresenter(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        btnSetting.setOnClickListener({
            val t = Thread({
                for (i in 1..1000) {
                    Thread.sleep(500)
//                    val mStoryModel = StoryModelImpl()
//                    mStoryModel.query(1, object : QueryListener<Story> {
//                        override fun onSuccess(data: ArrayList<Story>) {
//                            Log.d("test", "第" + i)
//                        }
//
//                        override fun onFailed(msg: String) {
//                            Log.d("test", "onFailed第" + i)
//                        }
//
//                    })
                }
            })
            t.start()
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }


}