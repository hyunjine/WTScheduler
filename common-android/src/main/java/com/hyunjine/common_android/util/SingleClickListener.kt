package com.hyunjine.common_android.util

import android.os.SystemClock
import android.view.View
import com.hyunjine.common.extension.DEFAULT

abstract class SingleClickListener(private val targetInterval: Long): View.OnClickListener {
    private var lastClickTimestamp: Long = Long.DEFAULT

    abstract fun onSingleClick(v: View?)
    override fun onClick(v: View?) {
        val a = 2
        val currentClickTimestamp = SystemClock.uptimeMillis()
        val elapsedTimestamp = currentClickTimestamp - lastClickTimestamp
        lastClickTimestamp = currentClickTimestamp

        if (elapsedTimestamp > targetInterval)
            onSingleClick(v)
    }
}