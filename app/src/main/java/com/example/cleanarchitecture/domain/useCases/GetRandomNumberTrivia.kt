package com.example.cleanarchitecture.domain.useCases

import com.example.cleanarchitecture.domain.commons.DataState
import com.example.cleanarchitecture.domain.commons.NoInternetFailure
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.repositories.NumberTriviaRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.net.UnknownHostException

class GetRandomNumberTrivia
constructor(
    private val numberTriviaRepository: NumberTriviaRepository
){

    suspend operator fun invoke(): Flow<DataState<NumberTrivia>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val trivia = numberTriviaRepository.getRandomNumberTrivia()
            emit(DataState.Success(trivia))
        } catch(ex: UnknownHostException) {
            val firstCached = numberTriviaRepository.getAllTrivia().first()
            emit(DataState.Success(firstCached))
        } catch (ex: Exception) {
            emit(DataState.ErrorOccurred(NoInternetFailure()))
        }
    }
}