package com.example.searchmovieapp.presentation.utils

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class ResponseWrapper<out T>(val status: Status, val data: T?, val message: Throwable?) {

    fun getResStatus(): Status {
        return status
    }

    fun getResData(): T? {
        return data
    }

    fun getResError(): Throwable? {
        return message
    }

    companion object {
        fun <T> loading(): ResponseWrapper<T> = ResponseWrapper(Status.LOADING, null, null)

        fun <T> success(data: T): ResponseWrapper<T> = ResponseWrapper(Status.SUCCESS, data, null)

        fun <T> error(data: T?, message: Throwable?): ResponseWrapper<T> =
            ResponseWrapper(Status.ERROR, data, message)

    }
}