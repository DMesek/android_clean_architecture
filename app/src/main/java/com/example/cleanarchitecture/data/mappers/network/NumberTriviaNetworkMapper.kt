package com.example.cleanarchitecture.data.mappers.network

import com.example.cleanarchitecture.data.mappers.NetworkEntityMapper
import com.example.cleanarchitecture.data.models.network.NumberTriviaNetwork
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import javax.inject.Inject

class NumberTriviaNetworkMapper
@Inject
constructor(): NetworkEntityMapper<NumberTrivia, NumberTriviaNetwork> {

    override fun mapToEntity(dataModel: NumberTriviaNetwork) =
        NumberTrivia(trivia = dataModel.text, number = dataModel.number)
}