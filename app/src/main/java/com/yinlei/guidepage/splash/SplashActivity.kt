package com.yinlei.guidepage.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.yinlei.guidepage.MainActivity
import com.yinlei.guidepage.R

/**
 * Splash方式实现引导页
 */
class SplashActivity : AppCompatActivity() {
    //停留时长
    private val DELAY_TIME = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        },DELAY_TIME)
    }
}
