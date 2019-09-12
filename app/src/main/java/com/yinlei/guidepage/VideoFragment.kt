package com.yinlei.guidepage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.video_fragment.*

class VideoFragment(val uriStrings: ArrayList<String>) : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index  = arguments?.getInt("index")
        val view = inflater.inflate(R.layout.video_fragment,null)
        val customVideo = view.findViewById<CustomVideoView>(R.id.customVideoView)
        val btn  = view.findViewById<Button>(R.id.main)
        btn.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }
        //最后一屏才显示进入主界面
        btn.visibility = if(index == 2) View.VISIBLE else View.GONE
        //加载视频文件
        customVideo.setVideoURI(Uri.parse(uriStrings[index!!]))
        //播放
        customVideo.start()
        return view
    }
}