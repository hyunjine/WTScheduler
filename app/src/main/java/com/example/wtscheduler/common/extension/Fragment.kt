package com.example.wtscheduler.common.extension

import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

fun Fragment.takeColor(@ColorRes colorId: Int): Int {
    return requireContext().takeColor(colorId)
}