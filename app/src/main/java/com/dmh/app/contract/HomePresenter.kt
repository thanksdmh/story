package com.dmh.app.contract

import com.dmh.app.module.QueryListener
import com.dmh.app.module.StoryModelImpl
import com.dmh.app.view.bean.Story

/**
 *@Author deng
 *@date 2018/10/24 0024.
 */
class HomePresenter(view: IHomeContact.IHomeView) : BasePresenter<IHomeContact.IHomeView>(), IHomeContact {
    private val mView = view
    private val mStoryModel = StoryModelImpl()

    override fun queryMore() {

        mStoryModel.query(object : QueryListener<Story> {
            override fun onSuccess(data: ArrayList<Story>) {
                mView.onLoadMore(data)

            }

            override fun onFailed(msg: String) {
                mView.onFailed(msg)
            }

        })

    }


    override fun query() {
        mStoryModel.query(object : QueryListener<Story> {
            override fun onSuccess(data: ArrayList<Story>) {
                mView.onLoad(data)
            }

            override fun onFailed(msg: String) {
                mView.onFailed(msg)

            }

        })

    }

}
