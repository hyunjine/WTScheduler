package com.example.wtscheduler.presenter.main

import androidx.lifecycle.lifecycleScope
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.common.util.DLog
import com.example.wtscheduler.data.remote.TestApi
import com.example.wtscheduler.databinding.ActivityMainBinding
import com.example.wtscheduler.presenter.exercise.ExerciseActivity
import com.example.wtscheduler.presenter.exp_purchase.ExpPurchaseActivity
import com.example.wtscheduler.presenter.main.figma.FigmaActivity
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    @Inject
    lateinit var service: TestApi

    data class Health(
        val name: String,
        val type: Int
    )

    override fun onClickEvent() = binding.run {
        lifecycleScope.launch {
            service.health()
                .onSuccess {
                    DLog.d(response.body()?.name)
                }.onFailure {
                    DLog.e(this)
                }.onError {
                    DLog.e(response.errorBody())
                }
        }
        clExpPurchase.setOnSingleClickListener {
            startActivity(FigmaActivity::class.java)
//            startActivity(ExpPurchaseActivity::class.java)
        }
        clExercise.setOnSingleClickListener {
            startActivity(ExerciseActivity::class.java)
        }
    }
}