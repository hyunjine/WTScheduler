package com.example.wtscheduler.common.extension

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.core.view.WindowCompat

fun Activity.fullScreen() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}
