package com.dmh.app.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmh.app.contract.BasePresenter
import com.dmh.app.contract.BaseView

/**
 * Created by dengmaohua on 2018/10/23 16:18.
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>?> : Fragment() {
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

    open fun getTitle(): String {
        return "标题"
    }

    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return if (inflater != null) {
            inflater.inflate(getLayoutId(), container, false)
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }
}