package com.example.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.data.SessionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: SessionRepository = SessionRepository(),
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(title = "Welcome"))
    val state: StateFlow<HomeState> = _state

    fun onRetry() {
        refresh()
    }

    fun onSignOut() {
        _state.value = HomeState(title = "Welcome")
    }

    fun refresh() {
        viewModelScope.launch {
            _state.value = HomeState(title = "Hello, ${repository.requireUser()}")
        }
    }
}

data class HomeState(val title: String)
