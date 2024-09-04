package com.hyunjine.common_android.extension

import android.view.View
import androidx.annotation.ColorRes
import com.hyunjine.common_android.util.SingleClickListener

fun View.setOnSingleClickListener(targetInterval: Long = 500L, listener: (View?) -> Unit = {}) {
    setOnClickListener(object : SingleClickListener(targetInterval) {
        override fun onSingleClick(v: View?) = listener(v)
    })
}

fun View.takeColor(@ColorRes colorId: Int): Int {
    return context.takeColor(colorId)
}