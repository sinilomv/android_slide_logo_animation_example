package com.github.exaples.android_slide_logo_animation_example


import android.app.AlertDialog
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.TextView
import android.view.animation.TranslateAnimation
import android.support.constraint.ConstraintLayout
import android.view.ViewTreeObserver

class StartLogo : AppCompatActivity() {

    var app: TextView? = null
    var logo: TextView? = null

    var width : Float = 0f
    var newWidth : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_logo)

        app = findViewById(R.id.textView4)
        logo = findViewById(R.id.textView3)

        animationText()


    }

    fun animationText(){
        val parent = findViewById(R.id.startLogoLayout) as ConstraintLayout
        parent.getViewTreeObserver().addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                val availableWidth = parent.measuredWidth
                parent.getViewTreeObserver().removeGlobalOnLayoutListener(this)

                var sumaryWidth = app!!.getMeasuredWidth() + logo!!.getMeasuredWidth()

                    width = (availableWidth - sumaryWidth)/2f
                    newWidth = 0 - width

                val appAnimation = TranslateAnimation(350f, newWidth, 0f, 0f)
                appAnimation.duration = 2000
                appAnimation.fillAfter = true
                appAnimation.setAnimationListener(MyAnimationListener())
                app!!.startAnimation(appAnimation)

                val logoAnimation = TranslateAnimation(-350f, width, 0f, 0f)
                logoAnimation.duration = 2000
                logoAnimation.fillAfter = true
                logoAnimation.setAnimationListener(MyAnimationListener())
                logo!!.startAnimation(logoAnimation)
            }
        })

    }

    private inner class MyAnimationListener : AnimationListener {

        override fun onAnimationEnd(animation: Animation) {
//            textFinder!!.clearAnimation()
//            val lp = ConstraintLayout.LayoutParams(textFinder!!.getWidth(), textFinder!!.getHeight())
//            lp.setMargins(0, 0, 40, 0)
//            textFinder!!.setLayoutParams(lp)
        }

        override fun onAnimationRepeat(animation: Animation) {}

        override fun onAnimationStart(animation: Animation) {

        }

    }


}
