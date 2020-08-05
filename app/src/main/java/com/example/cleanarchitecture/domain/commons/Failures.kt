package com.example.cleanarchitecture.domain.commons

sealed class Failure(val code: Int, val message: String)
class NoInternetFailure: Failure(404, "Ooops, check your internet connection.")