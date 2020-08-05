package com.example.cleanarchitecture.presentation.ui.concreteNumberTrivia

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.domain.useCases.GetAllTrivia
import com.example.cleanarchitecture.domain.useCases.GetConcreteNumberTrivia
import com.example.cleanarchitecture.domain.useCases.GetRandomNumberTrivia
import com.example.cleanarchitecture.presentation.commons.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class RandomTriviaViewModel
@ViewModelInject
constructor(
    private val getAllTrivia: GetAllTrivia,
    @Assisted savedStateHandle: SavedStateHandle
): BaseViewModel<ConcreteTriviaEvent, List<NumberTrivia>>() {

    @ExperimentalCoroutinesApi
    override fun mapEventToState(event: ConcreteTriviaEvent) {
        viewModelScope.launch {
            when(event) {
                is GetConcreteNumberTriviaEvent -> deliverUseCaseResult(getAllTrivia())
            }
        }
    }

}

sealed class ConcreteTriviaEvent
data class GetConcreteNumberTriviaEvent(val number: String): ConcreteTriviaEvent()