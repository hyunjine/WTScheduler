package com.example.wtscheduler.presenter.exercise

import android.os.Bundle
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.databinding.ActivityExerciseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseActivity : BaseActivity<ActivityExerciseBinding>({ ActivityExerciseBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}