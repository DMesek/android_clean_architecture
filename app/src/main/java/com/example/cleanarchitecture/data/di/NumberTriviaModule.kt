package com.example.cleanarchitecture.data.di

import com.example.cleanarchitecture.data.NumberTriviaDatabase
import com.example.cleanarchitecture.data.daos.NumberTriviaDao
import com.example.cleanarchitecture.data.mappers.CacheEntityMapper
import com.example.cleanarchitecture.data.mappers.NetworkEntityMapper
import com.example.cleanarchitecture.data.mappers.cache.NumberTriviaCacheMapper
import com.example.cleanarchitecture.data.mappers.network.NumberTriviaNetworkMapper
import com.example.cleanarchitecture.data.models.cache.NumberTriviaCache
import com.example.cleanarchitecture.data.models.network.NumberTriviaNetwork
import com.example.cleanarchitecture.data.repositories.NumberTriviaRepositoryImpl
import com.example.cleanarchitecture.data.services.NumberTriviaService
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.repositories.NumberTriviaRepository
import com.example.cleanarchitecture.domain.useCases.GetAllTrivia
import com.example.cleanarchitecture.domain.useCases.GetConcreteNumberTrivia
import com.example.cleanarchitecture.domain.useCases.GetRandomNumberTrivia
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object NumberTriviaModule  {

    @ActivityRetainedScoped
    @Provides
    fun provideCacheMapper(): CacheEntityMapper<NumberTrivia, NumberTriviaCache> = NumberTriviaCacheMapper()

    @ActivityRetainedScoped
    @Provides
    fun provideNetworkMapper(): NetworkEntityMapper<NumberTrivia, NumberTriviaNetwork> = NumberTriviaNetworkMapper()

    @ActivityRetainedScoped
    @Provides
    fun provideNumberTriviaDao(numberTriviaDb: NumberTriviaDatabase): NumberTriviaDao = numberTriviaDb.numberTriviaDao()

    @ActivityRetainedScoped
    @Provides
    fun provideNumberTriviaService(retrofit: Retrofit.Builder): NumberTriviaService
            = retrofit.build().create(NumberTriviaService::class.java)

    @ActivityRetainedScoped
    @Provides
    fun provideNumberTriviaRepository(
        numberTriviaDao: NumberTriviaDao,
        numberTriviaService: NumberTriviaService,
        cacheMapper: CacheEntityMapper<NumberTrivia, NumberTriviaCache>,
        networkMapper: NetworkEntityMapper<NumberTrivia, NumberTriviaNetwork>
    ): NumberTriviaRepository =
        NumberTriviaRepositoryImpl(
            numberTriviaDao,
            numberTriviaService,
            cacheMapper,
            networkMapper
        )

    @ActivityRetainedScoped
    @Provides
    fun provideRandomNumberTrivia(numberTriviaRepository: NumberTriviaRepository): GetRandomNumberTrivia
            = GetRandomNumberTrivia(numberTriviaRepository)

    @ActivityRetainedScoped
    @Provides
    fun provideConcreteNumberTrivia(numberTriviaRepository: NumberTriviaRepository): GetConcreteNumberTrivia
            = GetConcreteNumberTrivia(numberTriviaRepository)

    @ActivityRetainedScoped
    @Provides
    fun provideGetAllTrivia(numberTriviaRepository: NumberTriviaRepository): GetAllTrivia
            = GetAllTrivia(numberTriviaRepository)


}