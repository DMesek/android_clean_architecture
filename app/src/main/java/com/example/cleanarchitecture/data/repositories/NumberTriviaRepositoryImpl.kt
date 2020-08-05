package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.daos.NumberTriviaDao
import com.example.cleanarchitecture.data.mappers.CacheEntityMapper
import com.example.cleanarchitecture.data.mappers.NetworkEntityMapper
import com.example.cleanarchitecture.data.models.cache.NumberTriviaCache
import com.example.cleanarchitecture.data.models.network.NumberTriviaNetwork
import com.example.cleanarchitecture.data.services.NumberTriviaService
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.repositories.NumberTriviaRepository

class NumberTriviaRepositoryImpl
    constructor(
        private val numberTriviaDao: NumberTriviaDao,
        private val numberTriviaService: NumberTriviaService,
        private val cacheMapper: CacheEntityMapper<NumberTrivia, NumberTriviaCache>,
        private val networkMapper: NetworkEntityMapper<NumberTrivia, NumberTriviaNetwork>
    ): NumberTriviaRepository{

    override suspend fun getRandomNumberTrivia(): NumberTrivia {
        val networkTrivia = numberTriviaService.getRandomNumberTrivia()
        return cacheNumberTrivia(networkTrivia)
    }

    override suspend fun getConcreteNumberTrivia(number: String): NumberTrivia {
        val networkTrivia = numberTriviaService.getConcreteNumberTrivia(number = number.toInt())
        return cacheNumberTrivia(networkTrivia)
    }

    override suspend fun getAllTrivia(): List<NumberTrivia> {
        return numberTriviaDao.getAllTrivia().map { cacheMapper.mapToEntity(it) }
    }

    private suspend fun cacheNumberTrivia(networkTrivia: NumberTriviaNetwork): NumberTrivia {
        val numberTrivia = networkMapper.mapToEntity(networkTrivia)
        numberTriviaDao.insert(cacheMapper.mapFromEntity(numberTrivia))
        return numberTrivia
    }

}