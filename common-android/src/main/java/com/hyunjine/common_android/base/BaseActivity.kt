package com.hyunjine.common_android.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseActivity<T: ViewBinding, VM: BaseViewModel>(private val bindingFactory: (LayoutInflater) -> T): BasePureActivity<T>(bindingFactory) {
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    protected open fun observeViewModel(): Job = lifecycleScope.launch { }
}