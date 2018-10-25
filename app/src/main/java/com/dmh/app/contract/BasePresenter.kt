package com.dmh.app.contract

import android.util.Log
import java.lang.ref.WeakReference


/**
 * Created by dengmaohua on 2018/10/25 9:08.
 */
open class BasePresenter<T> {
    /** * 当内存不足释放内存  */
    protected var mViewRef: WeakReference<T>? = null // view 的弱引用

    /** * bind p with v * @param view  */
    fun attachView(view: T) {
        mViewRef = WeakReference(view)
    }

    fun detachView() {
        if (mViewRef != null) {
            mViewRef!!.clear()
            mViewRef = null
            Log.i("BasePresenter", "已经GC...")
        }
    }

    /** * 获取view的方法 * * @return 当前关联的view */
    fun getView(): T? {
        return mViewRef!!.get();
    }

}