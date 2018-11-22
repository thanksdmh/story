package com.dmh.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dmh.app.R
import com.dmh.app.adapter.holder.AuthorHolder
import com.dmh.app.view.bean.Author

/**
 *@name deng
 *@date 2018/10/30 0030.
 */
class AuthorAdapter(private var list: ArrayList<Author>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_lover_author, parent, false)
        return AuthorHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var item = list[position]
        if (holder is AuthorHolder) {
            holder.author!!.text = item.name
            holder.works!!.text = item.works.toString()
            holder.follow!!.text = item.follow.toString()
        }
    }

    private var itemClickListener: StoryAdapter.OnItemClickListener? = null
    fun addMore(data: ArrayList<Author>) {
        list.addAll(data)
        notifyDataSetChanged()
    }
}