package com.dmh.app.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.dmh.app.contract.BasePresenter
import com.dmh.app.contract.BaseView
import com.dmh.app.fragment.BaseFragment

/**
 * Created by dengmaohua on 2018/10/25 11:24.
 */
class MainAdapter(fm: FragmentManager, list: ArrayList<BaseFragment<BaseView, BasePresenter<BaseView>>>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): BaseFragment<BaseView, BasePresenter<BaseView>> {
        return list[position]
    }

    val list = list
    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return getItem(position).getTitle()
    }
}