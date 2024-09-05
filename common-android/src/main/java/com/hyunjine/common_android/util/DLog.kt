package com.hyunjine.common_android.util

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

    fun r(vararg msg: Any?) {
        val stackTrace = Thread.currentThread().stackTrace
        val currentMethodIndex = stackTrace.indexOfFirst { it.methodName == "r" }
        if (currentMethodIndex != -1 && currentMethodIndex + 1 < stackTrace.size) {
            val caller = stackTrace[currentMethodIndex + 1]
            val path = caller.toString()
                .split(".")
                .takeLast(3)
                .joinToString(", ")
                .replace("\$", "_")
            Log.i("winter","Path = $path")
        }
        Log.d("winter",  msg.joinToString("\n") + "\n")
    }
}