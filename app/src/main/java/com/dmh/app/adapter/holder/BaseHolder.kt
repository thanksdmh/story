package com.dmh.app.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dmh.app.R

/**
 *@author deng
 *@date 2018/10/22 0022.
 */
open class BaseHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var titleView: TextView? = itemView?.findViewById(R.id.tv_title)
}