package com.dmh.app

import android.os.Bundle
import com.dmh.app.view.bean.Story
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * 文章详情界面
 * Created by dengmaohua on 2018/10/23 16:16.
 */
class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.getBundleExtra("item")
        val item = bundle.getSerializable("item") as Story
        detail_tv_title.text = item.title
        detail_tv_content.text = item.content
    }
}