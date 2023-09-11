package com.example.wtscheduler.common.extension

import android.view.View
import com.example.wtscheduler.common.util.SingleClickListener

fun View.setOnSingleClickListener(targetInterval: Long = 500L, listener: (View?) -> Unit = {}) {
    setOnClickListener(object : SingleClickListener(targetInterval) {
        override fun onSingleClick(v: View?) = listener(v)
    })
}