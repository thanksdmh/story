package com.dmh.app.adapter.holder

import android.view.View
import android.widget.TextView
import com.dmh.app.R

/**
 *@Author deng
 *@date 2018/10/22 0022.
 */
class SimpleHolder(itemView: View?) : BaseHolder(itemView) {
    var tv_author: TextView? = itemView?.findViewById(R.id.tv_author)
    var tv_lover: TextView? = itemView?.findViewById(R.id.tv_lover)
}