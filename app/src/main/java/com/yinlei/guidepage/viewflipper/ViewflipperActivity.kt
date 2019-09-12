package com.yinlei.guidepage.viewflipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.yinlei.guidepage.R
import kotlinx.android.synthetic.main.activity_viewflipper.*
import kotlinx.android.synthetic.main.activity_viewpager.*
import kotlinx.android.synthetic.main.activity_viewpager.MyIndicator

class ViewflipperActivity : AppCompatActivity(), GestureDetector.OnGestureListener{
    private lateinit var getsDetector: GestureDetector
    private var index = 0//滑动到第几屏【当前是第几屏】

    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean = false

    override fun onDown(e: MotionEvent?): Boolean = false

    /**
     * 滑动中会调用的事件。比较e1,e2，判断差值然后判断是左还是右滑动，然后改变指示器的状态值
     */
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        index = if(e1!!.x > e2!!.x){
            //显示下一屏
            viewFlipper.showNext()
            if(index < 2) index + 1 else 0
        }else if(e1.x < e2.x){
            //显示下一屏
            viewFlipper.showPrevious()
            if(index > 0) index - 1 else 2
        }else {//手势相等
            return false
        }

        //改变指示器
        changeIndicator()
        return false
    }

    /**
     * 改变指示器
     */
    private fun changeIndicator() {
        for(i in 0 until  viewFlipper.childCount){
            MyIndicator.getChildAt(i).setBackgroundResource(if (index == i) R.drawable.dot_focus else R.drawable.dot_normal)
        }
    }

    /**
     * 左右滑动的过程
     */
    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
    }


    /**
     * 手势触摸方法
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //交给GestureDetector去做，然后依次调用它的回调方法
        return getsDetector.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewflipper)
        initIndicator()
        getsDetector = GestureDetector(this,this)
    }

    /**
     * 创建指示器
     */
    private fun initIndicator() {
        val width: Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10f,resources.displayMetrics).toInt()
        val lp = LinearLayout.LayoutParams(width, width)
        lp.rightMargin = 2*width
        for(i in 0 until viewFlipper.childCount){
            val view = View(this)
            view.id = i
            view.setBackgroundResource(if(i == 0) R.drawable.dot_focus else R.drawable.dot_normal)
            view.layoutParams = lp
            //线性布局动态添加每个小圆点
            MyIndicator.addView(view,i)
        }
    }
}
