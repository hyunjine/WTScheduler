package com.hyunjine.common_android.extension

import android.annotation.SuppressLint
import android.content.res.Resources

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun Resources.navigationBarHeight(): Int {
    val resourceId: Int = getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) getDimensionPixelSize(resourceId) else 0
}

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun Resources.statusBarHeight(): Int {
    val resourceId = getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) getDimensionPixelSize(resourceId) else 0
}