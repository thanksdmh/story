package com.dmh.app.fragment

import com.dmh.app.R
import com.dmh.app.contract.IMineContact
import com.dmh.app.contract.MinePresenter

/**
 * 个人中心
 * Created by dengmaohua on 2018/10/23 16:20.
 * 我的收藏
 * 喜欢的作者
 * 我的文章
 */
class MineFragment : BaseFragment<IMineContact.IMineView, MinePresenter>(), IMineContact.IMineView {
    override fun createPresenter(): MinePresenter {
        return MinePresenter(this)
    }

    override fun getTitle(): String {
        return if (isAdded) getString(R.string.menu_mine)
        else super.getTitle()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }


}