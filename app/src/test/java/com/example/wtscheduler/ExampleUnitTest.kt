package com.example.wtscheduler

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.lang.NullPointerException
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.random.Random
import kotlin.time.measureTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun main() {
        runTest {
            delay(3000L)
            println("1번째")
            delay(1000L)
            println("2번째")
        }
    }
    private suspend fun getUser(): String {
        return suspendCancellableCoroutine { cont ->
            getUser {
                println(it)
                cont.resumeWithException(NullPointerException())
            }
        }
    }

    private fun getUser(callBack: (String) -> Unit) {
        callBack("양현진")
    }
}
