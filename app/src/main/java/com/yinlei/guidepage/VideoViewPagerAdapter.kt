package com.yinlei.guidepage

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

/**
 * 适配器
 */
class VideoViewPagerAdapter(fm: FragmentManager, var fragments: MutableList<Fragment> ) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size



}