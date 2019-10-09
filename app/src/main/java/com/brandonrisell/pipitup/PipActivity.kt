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

        fab_pip.setOnClickListener { view ->
            val params = PictureInPictureParams.Builder()
                .setSourceRectHint(getFullScreenPlayerHintRect())
                .build()
            enterPictureInPictureMode(params)
            val intent = Intent()
                .setComponent(ComponentName(this, "com.brandonrisell.pipitup.MainActivity"))
                .setAction(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_LAUNCHER)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun pipAspectRatio() = Rational(16, 9)

    private fun getFullScreenPlayerHintRect(): Rect? {
        val rect = Rect()
        val windowView = this.window?.decorView ?: return null
        val windowWidth = windowView.width
        val windowHeight = windowView.height
        rect.set(0, 0, windowWidth, windowHeight)
        val aspectRatio = pipAspectRatio()
        val croppedHeight = windowWidth * aspectRatio.denominator / aspectRatio.numerator
        val croppedWidth = windowHeight * aspectRatio.numerator / aspectRatio.denominator
        if (croppedHeight <= windowHeight) {
            rect.inset(0, (windowHeight - croppedHeight) / 2)
        } else if (croppedWidth <= windowWidth) {
            rect.inset((windowWidth - croppedWidth) / 2, 0)
        }
        return rect
    }
}
