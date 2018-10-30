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
    var mModel: IAuthorModel = AuthorModelImpl()
    override fun queryMore() {
        mModel.query(mView.getType(), object : QueryListener<Author> {
            override fun onSuccess(data: ArrayList<Author>) {
                mView.onLoadMore(data)
            }

            override fun onFailed(msg: String) {
            }
        })
    }

    override fun query() {
        mModel.query(mView.getType(), object : QueryListener<Author> {
            override fun onSuccess(data: ArrayList<Author>) {
                mView.onLoad(data)
            }

            override fun onFailed(msg: String) {
            }
        })
    }

}