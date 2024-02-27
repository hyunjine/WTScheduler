package com.example.wtscheduler.common.extension

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.takeColor(@ColorRes colorId: Int): Int {
    return ContextCompat.getColor(applicationContext, colorId)
}

fun Context.takeDrawable(@DrawableRes drawableId: Int): Drawable? {
    return ContextCompat.getDrawable(applicationContext, drawableId)
}