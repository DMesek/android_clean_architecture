package com.example.cleanarchitecture.presentation.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.domain.commons.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseViewModel<InputEvent, OutputState>: ViewModel() {

    private val _dataState = MutableLiveData<DataState<OutputState>>()
    val dataState: LiveData<DataState<OutputState>>
        get() = _dataState

    abstract fun mapEventToState(event: InputEvent)

    @ExperimentalCoroutinesApi
    protected fun deliverUseCaseResult(useCase: Flow<DataState<OutputState>>) =
        useCase.onEach { _dataState.value = it }.launchIn(viewModelScope)
}