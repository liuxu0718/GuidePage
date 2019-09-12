package com.yinlei.guidepage.scrollview

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

class MyScrollView(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {

    private lateinit var onScrollChangeListener: OnScrollChangedListener

    /**
     *@param l  距离左边界的距离
     * @param t  距离上边界的距离
     * @param oldl  上一次的距离左边界的距离
     * @param oldt 上一次的距离上边界的距离
     */
    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if(onScrollChangeListener != null){
            onScrollChangeListener.onScrollChange(top,oldt)
        }
    }

    /**
     * 自定义的一个接口：
     * 自定义滑动的操作
     */
    interface OnScrollChangedListener{
        fun onScrollChange(top: Int,oldTop: Int)
    }

    fun getOnScrollChangedListener(): OnScrollChangedListener{
        return onScrollChangeListener
    }

    fun setOnScrollChangedListener(onScrollChangeListener: OnScrollChangedListener){
        this.onScrollChangeListener = onScrollChangeListener
    }
}

