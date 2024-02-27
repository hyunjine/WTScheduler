package com.example.wtscheduler.common.extension

import android.content.Context
import kotlin.math.roundToInt

val Int.Companion.DEFAULT: Int
    get() = 0

fun Int.dpToPx(context: Context): Int =
    (this * (context.resources.displayMetrics.densityDpi / 160f)).roundToInt()

fun Int.pxToDp(context: Context): Int =
    (this * (160f / context.resources.displayMetrics.densityDpi)).roundToInt()