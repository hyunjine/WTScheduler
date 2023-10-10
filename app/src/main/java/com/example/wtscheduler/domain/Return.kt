package com.example.wtscheduler.domain

class Return<T> private constructor(
    var status: Int,
    val value: T?,
//    val failBody: MainError.MainErrorModel = MainError.MainErrorModel(),
    var exception: Exception = defaultException
) {
    companion object {
        const val SUCCESS: Int = 0
        const val FAILURE: Int = 1
        const val ERROR: Int = 2

        val defaultException: Exception
            get() = Exception("오류가 발생했습니다.")

        fun<T> success(): Return<T> {
            return Return(status = SUCCESS, value = null)
        }

        fun<T> success(value: T): Return<T> {
            return Return(status = SUCCESS, value = value)
        }

//        fun<T> failure(): Return<T> {
//            return Return(status = FAILURE, value = null)
//        }
//
//        fun<T> failure(failBody: MainError.MainErrorModel): Return<T> {
//            return Return(status = FAILURE, value = null, failBody = failBody)
//        }
//
//        fun<T> failure(failBody: MainError.MainErrorModel, value: T): Return<T> {
//            return Return(status = FAILURE, value = value, failBody = failBody)
//        }

        fun<T> error(exception: Exception = defaultException): Return<T> {
            return Return(status = ERROR, value = null, exception = exception)
        }
    }
}

fun<T> Return<T>.onSingleSuccess(action: () -> Unit): Return<T> {
    if (status == Return.SUCCESS) {
        action()
    }
    return this
}

inline fun <reified T> Return<T>.onSuccess(action: (T) -> Unit): Return<T> {
    if (status == Return.SUCCESS && value == null) {
        status = Return.ERROR
        exception = NullPointerException("인자로 넘겨진 value: [${T::class.java.name}]가 null 입니다.")
        onError()
    } else if (status == Return.SUCCESS && value != null) {
        action(value)
    }
    return this
}

//suspend fun<T> Return<T>.onSingleFailure(action: suspend () -> Unit): Return<T> {
//    if (status == Return.FAILURE) {
//        action()
//    }
//    return this
//}
//
//
//fun<T> Return<T>.onFailure(action: (MainError.MainErrorModel) -> Unit): Return<T> {
//    if (status == Return.FAILURE) {
//        action(failBody)
//    }
//    return this
//}
//
//inline fun <reified T> Return<T>.onFailure(action: (MainError.MainErrorModel, T) -> Unit): Return<T> {
//    if (status == Return.FAILURE && value == null) {
//        status = Return.ERROR
//        exception = NullPointerException("인자로 넘겨진 value: [${T::class.java.name}]가 null 입니다.")
//        onError()
//    } else if (status == Return.FAILURE && value != null) {
//        action(failBody, value)
//    }
//    return this
//}

fun<T> Return<T>.onError(action: (Exception) -> Unit = {}): Return<T> {
    if (status == Return.ERROR) {
        action(exception)
    }
    return this
}

fun<T> Return<T>.onComplete(action: () -> Unit = {}): Return<T> {
    action()
    return this
}

fun<T> Return<T>.getOrDefault(defaultValue: T): T {
    return if (status == Return.SUCCESS && value != null) {
        value
    } else {
        defaultValue
    }
}