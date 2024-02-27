package com.example.wtscheduler.data.remote.interceptor

import com.example.wtscheduler.common.util.DLog
import com.example.wtscheduler.common.util.DLog.HTTP_LOG_TAG
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor

class PrettyHttpLoggingInterceptor: HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        if (message.startsWith("{") || message.startsWith("[")) {
            try {
                val prettyPrintJson = GsonBuilder().setPrettyPrinting()
                    .create().toJson(JsonParser.parseString(message))
                DLog.d(prettyPrintJson, HTTP_LOG_TAG)
            } catch (m: JsonSyntaxException) {
                DLog.e(message, HTTP_LOG_TAG)
            }
        } else {
            DLog.d(message, HTTP_LOG_TAG)
            return
        }
    }
}