package com.dmh.app.fragment

import com.dmh.app.R
import com.dmh.app.contract.FavorPresenter
import com.dmh.app.contract.IFavorContact

/**
 * 关注的作者文章列表
 * Created by dengmaohua on 2018/10/23 16:21.
 */
class FavorFragment : BaseFragment<IFavorContact.IFavorView, FavorPresenter>(), IFavorContact.IFavorView {
    override fun createPresenter(): FavorPresenter {
        return FavorPresenter(this)
    }

    override fun getTitle(): String {
//        return activity.getString(R.string.menu_favor)
        return if (isAdded)
            activity.getString(R.string.menu_favor)
        else super.getTitle()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_favor
    }
}