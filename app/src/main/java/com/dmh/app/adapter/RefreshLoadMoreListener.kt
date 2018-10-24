package com.dmh.app.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager


/**
 * Created by dengmaohua on 2018/10/23 15:59.
 */
abstract class RefreshLoadMoreListener : RecyclerView.OnScrollListener() {

    /**
     * 当前滑动的状态
     */
    private var currentScrollState: Int = 0
    /**
     * 最后一个可见的item的位置
     */
    private var lastVisibleItemPosition: Int = 0
    /**
     * 最后一个的位置
     */
    private var lastPositions: IntArray? = null

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        currentScrollState = newState
        val layoutManager = recyclerView.layoutManager
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        if (visibleItemCount > 0 && currentScrollState === RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition >= totalItemCount - 1) {
            onLoadMore()
        }
    }


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager

        when (layoutManager) {
            is LinearLayoutManager -> lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            is StaggeredGridLayoutManager -> {
                val staggeredGridLayoutManager = layoutManager as StaggeredGridLayoutManager
                if (lastPositions == null) {
                    lastPositions = IntArray(staggeredGridLayoutManager.spanCount)
                }
                staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions)
                lastVisibleItemPosition = findMax(lastPositions!!)
            }
        }
    }

    /**
     * 取数组中最大值
     *
     * @param lastPositions
     * @return
     */
    private fun findMax(lastPositions: IntArray): Int {
        val max = lastPositions.max()
                ?: lastPositions[0]

        return max
    }

    abstract fun onLoadMore()
}