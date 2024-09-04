package com.hyunjine.common_android.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseActivity<T: ViewBinding>(private val bindingFactory: (LayoutInflater) -> T): AppCompatActivity() {
    protected lateinit var binding: T
    protected val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingFactory(layoutInflater).also { binding = it }.root)
        setOnBackPressedListener()
        onClickEvent()
        observeViewModel()
    }

    protected open fun setOnBackPressedListener() {
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBack()
            }
        })
    }

    protected open fun onClickEvent() { }

    protected open fun observeViewModel() { }

    protected open fun onBack() {
        finish()
    }

    protected fun <T: Activity> startActivity(target: KClass<T>, block: Intent.() -> Unit = { }) {
        val intent = Intent(this, target.java)
        block(intent)
        startActivity(intent)
    }
}