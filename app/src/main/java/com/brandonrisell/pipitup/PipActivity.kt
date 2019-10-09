package com.brandonrisell.pipitup

import android.app.PictureInPictureParams
import android.content.ComponentName
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Rational
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_pip.*

class PipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pip)
        setSupportActionBar(toolbar_pip)

        fab_pip.setOnClickListener {
            val params = PictureInPictureParams.Builder()
                .setSourceRectHint(getSourceRectHint())
                .build()
            enterPictureInPictureMode(params)
        }
    }

    private fun getSourceRectHint(): Rect? {
        val rect = Rect()
        val windowView = this.window?.decorView ?: return null
        val windowWidth = windowView.width
        val windowHeight = windowView.height
        rect.set(0, 0, windowWidth, windowHeight)
        return rect
    }
}
