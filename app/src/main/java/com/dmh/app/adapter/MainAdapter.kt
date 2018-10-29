package com.dmh.app.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.dmh.app.fragment.BaseFragment

/**
 * Created by dengmaohua on 2018/10/25 11:24.
 */
class MainAdapter(fm: FragmentManager, list: ArrayList<BaseFragment<*, *>>?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): BaseFragment<*, *>? {
        return list?.get(position)
    }

    var list = list

    override fun getCount(): Int {
        return if (list == null) {
            0
        } else {
            list!!.size
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (getItem(position) == null) {
            ""
        } else getItem(position)!!.getTitle()
    }
}