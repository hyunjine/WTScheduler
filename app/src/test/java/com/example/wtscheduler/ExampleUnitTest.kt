package com.example.wtscheduler

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    interface OnClick {
        fun click(position: Int): String
    }

    @Test
    fun `과연 시발?`()  {
        val list = listOf(1, 2, 3)
        val (first, second, third, fourth) = list
        println(fourth)

        val test = Tess()

        test.setListener(object : OnClick {
            override fun click(position: Int): String {
                return "click"
            }
        })
        val dd = 2
        setListener(fun(dd): String {
            return "$dd"
        })

        val one: (Int) -> String = { a ->
            "$a"
        }

        val two = fun(a: Int): String {
            return "$a"
        }

        one
        two

    }

    private fun setListener(aa: fun(Int): String {

    })

    private fun setListener(listener: (Int) -> String) {

    }
}

class Tess {
    private var listener: ExampleUnitTest.OnClick? = null

    fun setListener(listener: ExampleUnitTest.OnClick) {
        this.listener = listener
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}

