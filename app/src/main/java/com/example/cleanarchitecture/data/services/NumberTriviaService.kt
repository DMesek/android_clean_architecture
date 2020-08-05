package com.example.cleanarchitecture.data.services

import com.example.cleanarchitecture.data.models.network.NumberTriviaNetwork
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface NumberTriviaService {

    @GET("{number}")
    suspend fun getConcreteNumberTrivia(@Header("Content-Type") contentType: String = "application/json",
                                        @Path("number") number: Int): NumberTriviaNetwork

    @GET("random/trivia")
    suspend fun getRandomNumberTrivia(@Header("Content-Type") contentType: String = "application/json"): NumberTriviaNetwork

}