package com.example.wtscheduler.presenter.exercise

import androidx.lifecycle.viewModelScope
import com.example.wtscheduler.common.base.BaseViewModel
import com.example.wtscheduler.common.base.UiState
import com.example.wtscheduler.domain.exercise.GetExerciseListUseCase
import com.example.wtscheduler.domain.onError
import com.example.wtscheduler.domain.onSuccess
import com.example.wtscheduler.presenter.exercise.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val getExerciseList: GetExerciseListUseCase
): BaseViewModel() {

    fun exerciseList() = viewModelScope.launch {
        getExerciseList()
            .onSuccess { data ->
                val model = data.map { Exercise.from(it) }
                emit(LoadExerciseList(model))
            }.onError {

            }
    }

    data class LoadExerciseList(val data: List<Exercise>): UiState()
}