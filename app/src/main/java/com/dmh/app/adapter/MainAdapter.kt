package com.dmh.app.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by dengmaohua on 2018/10/25 11:24.
 */
class MainAdapter(fm: FragmentManager, list: ArrayList<Fragment>?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
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
        return ""
    }
}