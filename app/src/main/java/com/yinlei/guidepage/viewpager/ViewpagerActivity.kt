package com.yinlei.guidepage.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.yinlei.guidepage.R
import kotlinx.android.synthetic.main.activity_viewpager.*
import android.widget.LinearLayout.LayoutParams as LayoutParams1

class ViewpagerActivity : AppCompatActivity() {
    private lateinit var adapter: PagerAdapter
    private  var fragments: MutableList<Fragment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        //创建Fragment
        for(i in 0 until  3){
            val fragment = ContentFragment()
            val bundle = Bundle()
            bundle.putInt("index", i)
            fragment.arguments = bundle
            fragments.add(fragment)
        }

        adapter = ViewPagerAdapter(supportFragmentManager,fragments)
        MyViewpager.adapter = adapter
        MyViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                for(i in 0 until fragments.size){
                    MyIndicator.getChildAt(i).setBackgroundResource(if(position == i) R.drawable.dot_focus else R.drawable.dot_normal)
                }
            }

            override fun onPageSelected(position: Int) {
            }

        })

        initIndicator()
    }

    /**
     * 创建指示器
     */
    private fun initIndicator() {
        val width: Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10f,resources.displayMetrics).toInt()
        val lp = LayoutParams1(width,width)
        lp.rightMargin = 2*width
       for(i in 0 until fragments.size){
           val view = View(this)
            view.id = i
           view.setBackgroundResource(if(i == 0) R.drawable.dot_focus else R.drawable.dot_normal)
           view.layoutParams = lp
           //线性布局动态添加每个小圆点
           MyIndicator.addView(view,i)
       }
    }
}
