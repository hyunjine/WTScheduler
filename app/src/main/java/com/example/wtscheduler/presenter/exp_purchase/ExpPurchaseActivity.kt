package com.example.wtscheduler.presenter.exp_purchase

import android.os.Bundle
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.databinding.ActivityExpPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpPurchaseActivity: BaseActivity<ActivityExpPurchaseBinding>({ ActivityExpPurchaseBinding.inflate(it) }) {
    private val rvPurchaseAdapter: ExpPurchaseAdapter by lazy {
        ExpPurchaseAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() = binding.rvPurchaseList.apply {
        adapter = rvPurchaseAdapter
        layoutManager =
    }
}