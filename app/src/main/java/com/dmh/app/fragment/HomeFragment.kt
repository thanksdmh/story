package com.dmh.app.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dmh.app.DetailActivity
import com.dmh.app.R
import com.dmh.app.adapter.RefreshLoadMoreListener
import com.dmh.app.adapter.StoryAdapter
import com.dmh.app.contract.HomePresenter
import com.dmh.app.contract.IHomeContact
import com.dmh.app.view.bean.Story
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 首页列表
 * Created by dengmaohua on 2018/10/23 16:18.
 */
class HomeFragment : BaseFragment<IHomeContact.IHomeView, HomePresenter>(), IHomeContact.IHomeView {


    override fun createPresenter(): HomePresenter {
        return HomePresenter(this)
    }

    private var adapter: StoryAdapter? = null
    override fun onLoadMore(data: ArrayList<Story>) {
        adapter!!.addMore(data)
    }

    override fun onLoad(data: ArrayList<Story>) {
        adapter = StoryAdapter(data)
        adapter!!.setItemClickListener(object : StoryAdapter.OnItemClickListener {
            override fun onItemClick(item: Story) {
                jumpToDetail(item)
            }
        })
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addOnScrollListener(object : RefreshLoadMoreListener() {
            override fun onLoadMore() {

            }
        })
    }

    override fun getTitle(): String {
        return getString(R.string.menu_home)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    fun jumpToDetail(item: Story) {
        val intent = Intent(activity, DetailActivity().javaClass)
        val b = Bundle()
        b.putSerializable("item", item)
        intent.putExtra("item", b)
        startActivity(intent)
    }
}