package com.hyunjine.common_android.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hyunjine.common_android.extension.dpToPx
import com.hyunjine.common_android.extension.pxToDp

abstract class BaseRecyclerViewHolder<T: ViewBinding>(
    binding: T
): RecyclerView.ViewHolder(binding.root) {
    protected val context: Context = binding.root.context

    protected val Int.dp
        get() = this.pxToDp(context)

    protected val Int.px
        get() = this.dpToPx(context)
}