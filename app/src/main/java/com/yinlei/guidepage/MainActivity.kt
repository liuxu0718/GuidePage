package com.yinlei.guidepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.video_fragment.*

/**
 * 主页面：
 * 充当视频引导页
 */
class MainActivity : AppCompatActivity() {

    private var fragments: MutableList<Fragment> = mutableListOf()
    private lateinit var adapter: VideoViewPagerAdapter
    val uriStrings = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        uriStrings.add("android.resource://$packageName/${R.raw.video1}")
        uriStrings.add("android.resource://$packageName/${R.raw.video2}")
        uriStrings.add("android.resource://$packageName/${R.raw.video3}")

        myViewpager.offscreenPageLimit = 3
        for(i in 0..2){
            val fragment = VideoFragment(uriStrings)
            val bundle = Bundle()
            bundle.putInt("index",i)
            fragment.arguments = bundle
            fragments.add(fragment)
        }

        adapter = VideoViewPagerAdapter(supportFragmentManager,fragments)
        myViewpager.adapter = adapter


        myViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                main.visibility = if(state == 2){
                    View.VISIBLE
                }else View.INVISIBLE
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

        })
    }
}
