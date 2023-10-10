package com.example.wtscheduler.presenter.exercise.model

import com.example.wtscheduler.domain.exercise.ExerciseModel

data class Exercise(
    val name: String,
    val priority: Int
) {
    companion object {
        fun from(data: ExerciseModel): Exercise {
            return Exercise(
                data.name,
                data.priority
            )
        }
    }
}
