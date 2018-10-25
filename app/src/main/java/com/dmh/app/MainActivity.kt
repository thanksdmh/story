package com.dmh.app

/**
 *@author deng
 *@date 2018/10/21 0021.
 */
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmh.app.adapter.MainAdapter
import com.dmh.app.fragment.BaseFragment
import com.dmh.app.fragment.FavorFragment
import com.dmh.app.fragment.HomeFragment
import com.dmh.app.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewpager()
    }

    private fun initViewpager() {
        var fragments = ArrayList<BaseFragment<*, *>>()
        //首页
        fragments.add(HomeFragment.newInstance(getString(R.string.menu_home)))
        //关注页
        fragments.add(FavorFragment())
        //个人中心
        fragments.add(MineFragment())
        tab_layout.setupWithViewPager(main_viewpager)
        main_viewpager.adapter = MainAdapter(supportFragmentManager, fragments)


    }


}

