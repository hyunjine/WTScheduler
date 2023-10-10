package com.example.wtscheduler.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    private val _uiEvent: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(DefaultState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()


    protected fun emit(event: UiEvent) {
        viewModelScope.launch { _uiEvent.emit(event) }
    }

    protected fun emit(state: UiState) {
        _uiState.value = state
    }

    object DefaultState: UiState()
}