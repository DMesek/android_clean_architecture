package com.example.cleanarchitecture.data.mappers.cache

import com.example.cleanarchitecture.data.mappers.CacheEntityMapper
import com.example.cleanarchitecture.data.models.cache.NumberTriviaCache
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import javax.inject.Inject

class NumberTriviaCacheMapper
@Inject
constructor(): CacheEntityMapper<NumberTrivia, NumberTriviaCache> {

    override fun mapToEntity(dataModel: NumberTriviaCache)
        = NumberTrivia(dataModel.trivia, dataModel.number)

    override fun mapFromEntity(entity: NumberTrivia)
        = NumberTriviaCache(entity.number, entity.trivia)

}