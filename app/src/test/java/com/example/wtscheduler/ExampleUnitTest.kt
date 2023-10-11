package com.example.wtscheduler

import com.example.wtscheduler.domain.exercise.ExerciseModel
import com.example.wtscheduler.domain.exercise.ExerciseRepository
import com.example.wtscheduler.domain.exercise.GetExerciseListUseCase
import com.example.wtscheduler.domain.getOrDefault
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    lateinit var repository: ExerciseRepository
    lateinit var useCase: GetExerciseListUseCase
//    lateinit var viewModel: ExerciseViewModel

    @Before
    fun setUp() {
//        repository = object : ExerciseRepository {
//            override suspend fun exerciseList(): List<ExerciseModel> {
//                return emptyList()
//            }
//        }
//        useCase = GetExerciseListUseCase(repository)
//        viewModel = ExerciseViewModel(useCase)
    }

    @Test
    fun `과연 시발?`()  {
        runTest {
            println(23123)
        }
//        runTest {
//            val a = useCase().getOrDefault(emptyList())
//            println(a)
//        }
    }
}

