package com.dmh.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmh.app.contract.BasePresenter
import com.dmh.app.contract.BaseView


/**
 * Created by dengmaohua on 2018/10/23 16:17.
 */
abstract class BaseActivity<V : BaseView, P : BasePresenter<V>?> : AppCompatActivity() {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    /**
     * 获取创建的Presenter对象，让子类去指定一个表示层
     *
     * @return 创建的Presenter对象
     */
    protected abstract fun createPresenter(): P

}