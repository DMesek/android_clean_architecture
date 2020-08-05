package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.domain.entities.NumberTrivia

interface NumberTriviaRepository {
    suspend fun getRandomNumberTrivia(): NumberTrivia
    suspend fun getConcreteNumberTrivia(number: String): NumberTrivia
    suspend fun getAllTrivia(): List<NumberTrivia>
}