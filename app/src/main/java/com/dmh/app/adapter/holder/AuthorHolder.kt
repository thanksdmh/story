package com.dmh.app.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dmh.app.R

/**
 *@author deng
 *@date 2018/10/30 0030.
 */
class AuthorHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var author: TextView? = itemView?.findViewById(R.id.tv_author)
    var works: TextView? = itemView?.findViewById(R.id.tv_works)
    var follow: TextView? = itemView?.findViewById(R.id.tv_follow)
}