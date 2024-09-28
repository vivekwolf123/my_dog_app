package com.client.vivekwolf.android.core_base

sealed class DataResult<out T, out E> {
    data class Success<out T>(val data: T) : DataResult<T, Nothing>()
    data class Error<out E>(val error: E) : DataResult<Nothing, E>()
}
