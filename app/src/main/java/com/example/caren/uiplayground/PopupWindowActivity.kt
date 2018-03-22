package com.example.caren.uiplayground

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.PopupWindow

/**
 * Activity for playing around with PopupWindow to explore animations, transitions, properties,
 * functionality and more
 */
class PopupWindowActivity : AppCompatActivity() {

    internal var elevation = 20f

    internal lateinit var pink: ColorDrawable
    internal lateinit var blue: ColorDrawable

    internal var x = 0
    internal var y = 0

    internal var last = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pink = ColorDrawable(resources.getColor(R.color.colorAccent))
        blue = ColorDrawable(resources.getColor(R.color.colorPrimary))

        findViewById<View>(R.id.btn).setOnClickListener { v ->
            val view = layoutInflater.inflate(if (last == 0)
                R.layout.popup_layout
            else
                R.layout.popup_layout_pink, null)
            val pWindow = PopupWindow(view, 300, 300)
            pWindow.elevation = elevation
            elevation = elevation + 20
            pWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y)
            x += 50
            y += 50
            last = if (last == 0) 1 else 0
        }
    }
}
