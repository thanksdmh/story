package com.dmh.app

/**
 *@Author deng
 *@date 2018/10/21 0021.
 */
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.dmh.app.adapter.MainAdapter
import com.dmh.app.fragment.FavorFragment
import com.dmh.app.fragment.HomeFragment
import com.dmh.app.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //去掉Activity上面的状态栏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        initViewpager()
    }

    private fun initViewpager() {
        var fragments = ArrayList<Fragment>()
        //首页
        fragments.add(HomeFragment())
        //关注页
        fragments.add(FavorFragment())
        //个人中心
        fragments.add(MineFragment())
        main_viewpager.offscreenPageLimit = 3
        main_viewpager.adapter = MainAdapter(supportFragmentManager, fragments)
        tab_layout.setupWithViewPager(main_viewpager)
        tab_layout.getTabAt(0)?.text = getString(R.string.menu_home)
        tab_layout.getTabAt(1)?.text = getString(R.string.menu_favor)
        tab_layout.getTabAt(2)?.text = getString(R.string.menu_mine)

    }


}

