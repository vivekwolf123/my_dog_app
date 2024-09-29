package com.client.vivekwolf.android.feature_base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel<State : Any, Effect : Any>(
    initialState: State
) : ViewModel() {

    protected val _viewState = MutableStateFlow(initialState)
    val viewState: StateFlow<State> = _viewState.asStateFlow()

    private val _effect = Channel<Effect>(capacity = Channel.CONFLATED)
    val effect = _effect.receiveAsFlow()

    protected fun updateState(reducer: (State) -> State) {
        _viewState.value = reducer(_viewState.value)
    }

    protected fun sendEffect(effect: Effect) {
        _effect.trySend(effect).isSuccess
    }
}
