package com.example.cleanarchitecture.domain.useCases

import com.example.cleanarchitecture.domain.commons.DataState
import com.example.cleanarchitecture.domain.commons.NoInternetFailure
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.repositories.NumberTriviaRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetConcreteNumberTrivia
constructor(
    private val numberTriviaRepository: NumberTriviaRepository
){

    suspend operator fun invoke(number: String): Flow<DataState<NumberTrivia>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val trivia = numberTriviaRepository.getConcreteNumberTrivia(number)
            emit(DataState.Success(trivia))
        } catch (ex: Exception) {
            emit(DataState.ErrorOccurred(NoInternetFailure()))
        }
    }
}