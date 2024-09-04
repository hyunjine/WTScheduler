package com.example.wtscheduler.common.util

import android.util.Log

object DLog {
    const val HTTP_LOG_TAG: String = "okhttp.OkHttpClient"
    private const val TAG: String = "winter"
    fun d(msg: Any?, tag: String = TAG) {
        Log.d(tag, msg.toString())
    }

    fun e(msg: Any?, tag: String = TAG) {
        Log.e(tag, msg.toString())
    }

    fun i(msg: Any?, tag: String = TAG) {
        Log.i(tag, msg.toString())
    }

    fun r(msg: Any?, tag: String = TAG) {
        Log.d(tag, msg.toString())
    }
}