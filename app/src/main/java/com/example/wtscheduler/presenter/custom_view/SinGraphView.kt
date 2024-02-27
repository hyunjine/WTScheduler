package com.example.wtscheduler.presenter.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.wtscheduler.R
import com.example.wtscheduler.common.extension.takeColor
import kotlin.math.sin

class SinGraphView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint()
    private lateinit var points: FloatArray

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        paint.color = takeColor(R.color.black)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Sin 그래프를 그리기 위한 점들 계산
        calculatePoints()

        // 캔버스에 Sin 그래프 그리기
        canvas.drawLines(points, paint)
    }

    private fun calculatePoints() {
        val numPoints = width / 5 // 그래프에 사용할 점의 개수
        points = FloatArray(numPoints * 4) // 각 점은 x, y 좌표를 나타내므로 * 4

        for (i in 0 until numPoints) {
            val x = i * 5f
            val y = (height / 2 * (1 - sin(Math.toRadians(x.toDouble())))).toFloat() // sin 함수 계산

            points[i * 4] = x
            points[i * 4 + 1] = y

            // 다음 점과 연결하기 위해 직선의 끝점 설정
            if (i > 0) {
                points[i * 4 - 2] = x
                points[i * 4 - 1] = y
            }
        }
    }
}