package com.yinlei.guidepage.viewpager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.yinlei.guidepage.MainActivity
import com.yinlei.guidepage.R

class ContentFragment : Fragment() {
    //背景图片资源
    private val BgRes: MutableList<Int> = mutableListOf(R.drawable.bg1,R.drawable.bg2,
        R.drawable.bg3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frament_content,null)
        val btn = view.findViewById<Button>(R.id.GotoMain)
        val rl = view.findViewById<RelativeLayout>(R.id.RL)

        val index  = arguments?.getInt("index")
        rl.setBackgroundResource(BgRes[index!!])
        btn.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }
        //最后一屏才显示进入主界面
        btn.visibility = if(index == 2) View.VISIBLE else View.GONE
        return view
    }
}