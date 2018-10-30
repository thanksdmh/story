package com.dmh.app.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.dmh.app.DetailActivity
import com.dmh.app.R
import com.dmh.app.adapter.RefreshLoadMoreListener
import com.dmh.app.adapter.StoryAdapter
import com.dmh.app.contract.HomePresenter
import com.dmh.app.contract.IHomeContact
import com.dmh.app.view.bean.Story
import kotlinx.android.synthetic.main.fragment_story_list.*

/**
 *@author deng
 *@date 2018/10/30 0030.
 */
class StoryListFragment : BaseContactFragment<IHomeContact.IHomeView, HomePresenter>(), IHomeContact.IHomeView {
    override fun getType(): Int {
        return mtype
    }

    private var adapter: StoryAdapter? = null
    public var mtype: Int = 0
        set(value) {
            field = value
        }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        mPresenter?.query()
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter(this)
    }

    private fun init() {
        Log.i("fragment", this.javaClass.name)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addOnScrollListener(object : RefreshLoadMoreListener() {
            override fun onLoadMore() {
                adapter?.showLoadingMore()
                mPresenter?.queryMore()
            }
        })
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_story_list
    }


    override fun onLoadMore(data: ArrayList<Story>) {
        activity.runOnUiThread {
            adapter?.addMore(data)
        }

    }


    override fun onLoad(data: ArrayList<Story>) {
        adapter = StoryAdapter(data)
        adapter!!.setItemClickListener(object : StoryAdapter.OnItemClickListener {
            override fun onItemClick(item: Story) {
                jumpToDetail(item)
            }
        })
        activity.runOnUiThread {
            recyclerView.adapter = adapter
        }
    }

    override fun onFailed(msg: String) {

    }

    fun jumpToDetail(item: Story) {
        val intent = Intent(activity, DetailActivity().javaClass)
        val b = Bundle()
        b.putSerializable("item", item)
        intent.putExtra("item", b)
        startActivity(intent)
    }
}