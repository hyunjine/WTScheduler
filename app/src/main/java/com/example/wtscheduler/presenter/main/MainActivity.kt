package com.example.wtscheduler.presenter.main

import android.os.Bundle
import com.example.wtscheduler.databinding.ActivityMainBinding
import com.hyunjine.common_android.base.BaseActivity
import com.hyunjine.purchase.PurchasePlanActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onUiEvent()
    }

    private fun onUiEvent() = binding.run {
        tvEnterPurchase.setOnClickListener {
            startActivity(PurchasePlanActivity::class)
        }
    }
}