package com.example.cleanarchitecture.data.models.network

import com.google.gson.annotations.SerializedName

class NumberTriviaNetwork(
    @SerializedName("number")
    val number: Int,
    @SerializedName("text")
    val text: String
)