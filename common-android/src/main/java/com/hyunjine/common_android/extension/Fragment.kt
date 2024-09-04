package com.hyunjine.common_android.extension

import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

fun Fragment.takeColor(@ColorRes colorId: Int): Int {
    return requireContext().takeColor(colorId)
}