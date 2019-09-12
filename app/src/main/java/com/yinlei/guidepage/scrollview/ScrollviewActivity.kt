package com.yinlei.guidepage.scrollview

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import com.yinlei.guidepage.MainActivity
import com.yinlei.guidepage.R
import kotlinx.android.synthetic.main.activity_scrollview.*

class ScrollviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollview)
        GotoMain.setOnClickListener {
            startActivity(Intent(this@ScrollviewActivity, MainActivity::class.java))
            finish()
        }

        myScroll.setOnScrollChangedListener(object : MyScrollView.OnScrollChangedListener {
            override fun onScrollChange(top: Int, oldTop: Int) {
                if(top > oldTop){//上滑操作
                    val anim = AnimationUtils.loadAnimation(
                        this@ScrollviewActivity,R.anim.show
                    )
                    LlAnim.visibility = View.VISIBLE
                    LlAnim.startAnimation(anim)
                } else{//下滑
                    val anim = AnimationUtils.loadAnimation(
                        this@ScrollviewActivity,R.anim.close
                    )
                    LlAnim.visibility = View.INVISIBLE
                    LlAnim.startAnimation(anim)
                }
            }

        })
    }
}
