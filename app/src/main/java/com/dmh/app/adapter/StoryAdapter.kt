package com.dmh.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dmh.app.R
import com.dmh.app.adapter.holder.BaseHolder
import com.dmh.app.adapter.holder.LoadMoreHolder
import com.dmh.app.adapter.holder.OnePicHolder
import com.dmh.app.adapter.holder.SimpleHolder
import com.dmh.app.view.bean.Story


/**
 *@author deng
 *@date 2018/10/21 0021.
 */
class StoryAdapter(private var list: ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null

    fun setItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addMore(data: List<Story>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Story.LOAD_MORE -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.load_more_item, parent, false)
                return LoadMoreHolder(view)
            }

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


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val story = list[position]
        if (holder == null) {
            return
        }
        if (holder is BaseHolder) {
            holder.titleView!!.text = story.title
            if(holder.contentView!=null) {
                holder.contentView!!.text = story.content
            }
            holder.itemView.setOnClickListener({
                itemClickListener?.onItemClick(story)
            })
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

    interface OnItemClickListener {
        fun onItemClick(item: Story)
    }


}