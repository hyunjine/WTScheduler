package com.example.wtscheduler.common.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.wtscheduler.R

abstract class BaseActivity<T: ViewBinding>(private val bindingFactory: (LayoutInflater) -> T): AppCompatActivity() {
    protected lateinit var binding: T
    protected val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingFactory(layoutInflater).also { binding = it }.root)
        setOnBackPressedListener()
    }

    protected open fun setOnBackPressedListener() {
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBack()
            }
        })
    }

    protected open fun onBack() {
        finish()
    }

    override fun startActivity(intent: Intent) {
        startActivity(intent, R.anim.slide_in_right, R.anim.none)
    }

    protected fun<T: Activity> startActivity(
        target: Class<T>,
        enterAnim: Int = R.anim.slide_in_right,
        exitAnim: Int = R.anim.none
    ) {
        startActivity(Intent(this, target), enterAnim, exitAnim)
    }

    protected fun startActivity(
        intent: Intent,
        enterAnim: Int,
        exitAnim: Int
    ) {
        super.startActivity(intent)
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, enterAnim, exitAnim)
        } else {
            @Suppress("DEPRECATION")
            overridePendingTransition(enterAnim, exitAnim)
        }
    }

    override fun finish() {
        finish(R.anim.none, R.anim.slide_out_left)
    }

    protected fun finish(
        enterAnim: Int,
        exitAnim: Int
    ) {
        super.finish()
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(OVERRIDE_TRANSITION_CLOSE, enterAnim, exitAnim)
        }else {
            @Suppress("DEPRECATION")
            overridePendingTransition(enterAnim, exitAnim)
        }
    }
}