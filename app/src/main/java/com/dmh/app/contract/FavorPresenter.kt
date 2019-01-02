package com.dmh.app.contract

import com.dmh.app.module.AuthorModelImpl
import com.dmh.app.module.IAuthorModel
import com.dmh.app.module.QueryListener
import com.dmh.app.view.bean.Author

/**
 * Created by dengmaohua on 2018/10/25 11:40.
 */
class FavorPresenter(view: IFavorContact.IFavorView) : BasePresenter<IFavorContact.IFavorView>(), IFavorContact {
    private val mView = view
    private val mPageSize = 10
    private var mPageIndex = 1
    var mModel: IAuthorModel = AuthorModelImpl()
    override fun queryMore() {
        mPageIndex++
        mModel.query(mView.getType(), mPageSize, mPageIndex, object : QueryListener<Author> {
            override fun onSuccess(data: ArrayList<Author>) {
                mView.onLoadMore(data)
            }

            override fun onFailed(msg: String) {
            }
        })
    }

    override fun query() {
        mPageIndex = 1
        mModel.query(mView.getType(), mPageSize, mPageIndex, object : QueryListener<Author> {
            override fun onSuccess(data: ArrayList<Author>) {
                mView.onLoad(data)
            }

            override fun onFailed(msg: String) {
            }
        })
    }

}