package com.hyunjine.common_android.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.hyunjine.common.extension.DEFAULT
import com.hyunjine.common_android.R
import com.hyunjine.common_android.databinding.LayoutAppBarBinding

class AppBar: ConstraintLayout {
    private val binding by lazy {
        LayoutAppBarBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.layout_app_bar, this, false)
        )
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        context.obtainStyledAttributes(attrs, R.styleable.AppBar).let { ta ->
            val title = ta.getString(R.styleable.AppBar_title) ?: String.DEFAULT
            initView(title)
            ta.recycle()
        }
    }

    var onBackClickListener: () -> Unit = {}
        set(value) {
            field = value
            binding.imgLeft.setOnClickListener {
                value()
            }
        }

    var title: String = String.DEFAULT
        set(value) {
            field = value
            binding.tvTitle.text = value
        }

    private fun initView(title: String) {
        addView(binding.root)
        this.title = title
    }
}