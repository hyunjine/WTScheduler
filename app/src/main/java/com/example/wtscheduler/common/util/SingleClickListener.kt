package com.example.wtscheduler.common.util

import android.os.SystemClock
import android.view.View
import com.example.wtscheduler.common.extension.DEFAULT

abstract class SingleClickListener(private val targetInterval: Long): View.OnClickListener {
    private var lastClickTimestamp: Long = Long.DEFAULT

    abstract fun onSingleClick(v: View?)
    override fun onClick(v: View?) {
        val currentClickTimestamp = SystemClock.uptimeMillis()
        val elapsedTimestamp = currentClickTimestamp - lastClickTimestamp
        lastClickTimestamp = currentClickTimestamp

        if (elapsedTimestamp > targetInterval)
            onSingleClick(v)
    }
}