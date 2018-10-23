package com.dmh.app.adapter.holder

import android.view.View
import android.widget.ImageView
import com.dmh.app.R

/**
 *@author deng
 *@date 2018/10/22 0022.
 */
class OnePicHolder(itemView: View?) : BaseHolder(itemView) {
    var imageView: ImageView? = itemView?.findViewById(R.id.img_content)
}