package com.yinlei.guidepage

import android.content.Context
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.VideoView


class CustomVideoView : VideoView {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //重新计算高度
        val width = getDefaultSize(0, widthMeasureSpec)
        val height = getDefaultSize(0, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }


    override fun setOnPreparedListener(l: MediaPlayer.OnPreparedListener?) {
        super.setOnPreparedListener(l)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
    }

}