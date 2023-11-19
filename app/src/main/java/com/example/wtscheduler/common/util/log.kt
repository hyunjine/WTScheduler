package com.example.wtscheduler.common.util

import android.util.Log

object log {
    private const val TAG: String = "winter"
    fun d(msg: Any?) {
        Log.d(TAG, msg.toString())
    }
}