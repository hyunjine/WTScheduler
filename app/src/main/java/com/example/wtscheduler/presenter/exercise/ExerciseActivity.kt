package com.example.wtscheduler.presenter.exercise

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.base.BaseViewModel
import com.example.wtscheduler.databinding.ActivityExerciseBinding
import com.example.wtscheduler.presenter.exercise.adapter.ExerciseAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExerciseActivity : BaseActivity<ActivityExerciseBinding>({ ActivityExerciseBinding.inflate(it) }) {
    private val viewModel: ExerciseViewModel by viewModels()
    private val rvExerciseAdapter: ExerciseAdapter by lazy {
        ExerciseAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRecyclerView()
        onClickEvent()
        observeViewModel()
        viewModel.exerciseList()
    }

    private fun setRecyclerView() = binding.run {
        rvExercise.adapter = rvExerciseAdapter
        rvExercise.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onClickEvent() = binding.run {

    }
    override fun observeViewModel(): Unit = binding.run {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is BaseViewModel.DefaultState -> {

                    }
                    is ExerciseViewModel.LoadExerciseList -> {
                        rvExerciseAdapter.submitList(state.data)
                    }
                }
            }
        }
        lifecycleScope.launch {
            viewModel.uiEvent.collect { event ->
                when (event) {

                }
            }
        }
    }
}