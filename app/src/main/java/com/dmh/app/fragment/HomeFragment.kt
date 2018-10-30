package com.dmh.app.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.dmh.app.R
import com.dmh.app.adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 首页列表
 * Created by dengmaohua on 2018/10/23 16:18.
 */
class HomeFragment : BaseFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        var fragments = ArrayList<Fragment>()
        //幽默
        fragments.add(StoryListFragment())
        var storyListFragment = StoryListFragment()
        storyListFragment.mtype = 1
        //冷笑话
        fragments.add(storyListFragment)
        home_viewpager.offscreenPageLimit = 3
        home_viewpager.adapter = MainAdapter(childFragmentManager, fragments)
        home_tab.setupWithViewPager(home_viewpager)
        home_tab.getTabAt(0)?.text = getString(R.string.menu_home_ymo)
        home_tab.getTabAt(1)?.text = getString(R.string.menu_home_lxh)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


}