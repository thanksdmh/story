package com.dmh.app.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.dmh.app.R
import com.dmh.app.adapter.AuthorAdapter
import com.dmh.app.adapter.RefreshLoadMoreListener
import com.dmh.app.contract.FavorPresenter
import com.dmh.app.contract.IFavorContact
import com.dmh.app.view.bean.Author
import kotlinx.android.synthetic.main.fragment_story_list.*

/**
 *@author deng
 *@date 2018/10/30 0030.
 */
class AuthorListFragment : BaseContactFragment<IFavorContact.IFavorView, FavorPresenter>(), IFavorContact.IFavorView {


    var mAdapter: AuthorAdapter? = null
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        mPresenter?.query()
    }

    private fun init() {
        Log.i("fragment", this.javaClass.name)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addOnScrollListener(object : RefreshLoadMoreListener() {
            override fun onLoadMore() {
                mPresenter?.queryMore()
            }
        })
    }

    override fun createPresenter(): FavorPresenter {
        return FavorPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_story_list
    }

    override fun onLoad(data: ArrayList<Author>) {
        mAdapter = AuthorAdapter(data)

        activity.runOnUiThread {
            recyclerView.adapter = mAdapter
        }
    }

    override fun onLoadMore(data: ArrayList<Author>) {
        activity.runOnUiThread {
            mAdapter?.addMore(data)
        }

    }

    override fun onFailed(msg: String) {
    }

    override fun getType(): Int {
        return mtype
    }

    public var mtype: Int = 1
        get() = field
        set(value) {
            field = value
        }
}