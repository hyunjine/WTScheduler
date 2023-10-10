package com.example.wtscheduler.data.exercise

import com.example.wtscheduler.domain.exercise.ExerciseModel
import com.example.wtscheduler.domain.exercise.ExerciseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class ExerciseRepositoryImpl @Inject constructor(): ExerciseRepository {
    override suspend fun exerciseList(): List<ExerciseModel> {
        val entity = listOf(
            ExerciseEntity("등", 1),
            ExerciseEntity("하체", 2),
            ExerciseEntity("가슴", 3)
        )
        return entity.map {
            it.toModel()
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    @Singleton
    abstract fun provideServiceHelper(threeServiceHelper: ExerciseRepositoryImpl): ExerciseRepository
}