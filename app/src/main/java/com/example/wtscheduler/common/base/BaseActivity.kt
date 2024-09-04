package com.example.wtscheduler.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

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

    protected open fun observeViewModel(): Unit { }

    protected open fun onBack() {
        finish()
    }
}