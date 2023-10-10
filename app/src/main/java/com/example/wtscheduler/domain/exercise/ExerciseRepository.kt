package com.example.wtscheduler.domain.exercise

interface ExerciseRepository {
    suspend fun exerciseList(): List<ExerciseModel>
}