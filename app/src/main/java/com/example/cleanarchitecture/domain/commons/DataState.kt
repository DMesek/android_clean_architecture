package com.example.cleanarchitecture.domain.commons

sealed class DataState<out R> {
    data class Success<out T>(val data: T): DataState<T>()
    data class ErrorOccurred(val failure: Failure): DataState<Nothing>()
    object Loading: DataState<Nothing>()
}