package com.dmh.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dmh.app.R
import com.dmh.app.adapter.holder.BaseHolder
import com.dmh.app.adapter.holder.OnePicHolder
import com.dmh.app.adapter.holder.SimpleHolder
import com.dmh.app.view.bean.Story


/**
 *@author deng
 *@date 2018/10/21 0021.
 */
class StoryAdapter(private var list: List<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {

            Story.SIMPLE -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.simple_item, parent, false)
                return SimpleHolder(view)
            }
            Story.ONE_PIC_START -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.one_pic_item, parent, false)
                return OnePicHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.simple_item, parent, false)
                return SimpleHolder(view)
            }

        }

    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val story = list[position]
        if (holder == null) {
            return
        }
        if (holder is BaseHolder) {
            holder.titleView!!.text = story.title
        }
        when (holder) {
            is OnePicHolder -> {
                var options = RequestOptions().error(R.mipmap.error)
                        .placeholder(R.mipmap.loading)
                Glide.with(holder.imageView!!.context)
                        .load(story.picUrlList!![0])
                        .apply(options)
                        .into(holder.imageView)

            }
        }


    }


}