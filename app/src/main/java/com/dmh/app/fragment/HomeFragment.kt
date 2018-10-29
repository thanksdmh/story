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
    private var adapter: StoryAdapter? = null
    private var title: String? = ""

    companion object {// 包裹范围内 属于静态方法

        fun newInstance(title: String): BaseFragment<*, *> {

            val args = Bundle()
            args.putString("title", title)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        title = arguments.getString("title")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        mPresenter?.query()
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter(this)
    }


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
        recyclerView.adapter = adapter;
    }


    private fun init() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addOnScrollListener(object : RefreshLoadMoreListener() {
            override fun onLoadMore() {

            }
        })
    }

    override fun getTitle(): String {
        return title.toString()
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