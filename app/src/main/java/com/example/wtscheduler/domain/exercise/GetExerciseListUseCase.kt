package com.example.wtscheduler.domain.exercise

import com.example.wtscheduler.domain.Return
import javax.inject.Inject

class GetExerciseListUseCase @Inject constructor(
    private val exerciseRepo: ExerciseRepository
) {
    suspend operator fun invoke(): Return<List<ExerciseModel>> {
        return Return.success(exerciseRepo.exerciseList())
    }
}