package com.example.wtscheduler.data.remote

import com.example.wtscheduler.presenter.main.MainActivity
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi {
    @GET("health")
    suspend fun health(): ApiResponse<MainActivity.Health>
}