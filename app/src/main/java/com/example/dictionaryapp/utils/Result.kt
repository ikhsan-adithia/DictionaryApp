package com.example.dictionaryapp.utils

sealed class Result<T>(
    val data: T? = null,
    val uiText: UiText? = null
) {
    class Success<T> (data: T): Result<T>(data)
    class Error<T> (data: T? = null, uiText: UiText? = null): Result<T>(data, uiText)
    class Loading<T> (data: T? = null): Result<T>()
}
