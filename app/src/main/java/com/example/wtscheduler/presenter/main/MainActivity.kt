package com.example.wtscheduler.presenter.main

import android.os.Bundle
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.databinding.ActivityMainBinding
import com.example.wtscheduler.presenter.exercise.ExerciseActivity
import com.example.wtscheduler.presenter.exp_purchase.ExpPurchaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onClickEvent()
    }

    private fun onClickEvent() = binding.run {
        clExpPurchase.setOnSingleClickListener {
            startActivity(ExpPurchaseActivity::class.java)
        }
        clExercise.setOnSingleClickListener {
            startActivity(ExerciseActivity::class.java)
        }
    }
}