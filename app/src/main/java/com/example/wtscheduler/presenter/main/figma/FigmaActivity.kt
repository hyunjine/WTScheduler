package com.example.wtscheduler.presenter.main.figma

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.view.setPadding
import androidx.core.view.updatePadding
import com.example.wtscheduler.R
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.dpToPx
import com.example.wtscheduler.common.extension.fullScreen
import com.example.wtscheduler.common.extension.navigationBarHeight
import com.example.wtscheduler.common.extension.statusBarHeight
import com.example.wtscheduler.databinding.ActivityFigmaBinding

class FigmaActivity : BaseActivity<ActivityFigmaBinding>({ ActivityFigmaBinding.inflate(it) }) {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.root.updatePadding(24.dpToPx(this), resources.statusBarHeight(), 24.dpToPx(this), resources.navigationBarHeight())

        binding.clMainDesBox.setRenderEffect(
            RenderEffect.createBlurEffect(
                30f,
                30f,
                Shader.TileMode.CLAMP
            )
        )
    }
}