package com.example.cleanarchitecture.presentation.ui.randomNumberTrivia

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.useCases.GetConcreteNumberTrivia
import com.example.cleanarchitecture.domain.useCases.GetRandomNumberTrivia
import com.example.cleanarchitecture.presentation.commons.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class RandomTriviaViewModel
@ViewModelInject
constructor(
    private val getRandomNumberTrivia: GetRandomNumberTrivia,
    @Assisted savedStateHandle: SavedStateHandle
): BaseViewModel<RandomTriviaEvent, NumberTrivia>() {

    @ExperimentalCoroutinesApi
    override fun mapEventToState(event: RandomTriviaEvent) {
        viewModelScope.launch {
            when(event) {
                is GetRandomNumberTriviaEvent -> deliverUseCaseResult(getRandomNumberTrivia())
            }
        }
    }

}

sealed class RandomTriviaEvent
object GetRandomNumberTriviaEvent: RandomTriviaEvent()