package com.example.wtscheduler.data.exercise

import com.example.wtscheduler.common.extension.DEFAULT
import com.example.wtscheduler.domain.exercise.ExerciseModel

data class ExerciseEntity(
    val name: String?,
    val priority: Int?
) {
    fun toModel(): ExerciseModel {
        return ExerciseModel(
            name ?: String.DEFAULT,
            priority ?: Int.DEFAULT
        )
    }
}
