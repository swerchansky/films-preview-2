package swerchansky.films.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import swerchansky.films.domain.base.BaseState

abstract class BaseEventHandler<T : BaseUiEvent, E : BaseState>(initial: E) {
    private val mutableState = MutableStateFlow(initial)
    val state: StateFlow<E>
        get() = mutableState

    fun sendEvent(event: T) = handleEvent(mutableState.value, event)
    fun setState(newState: E) = mutableState.tryEmit(newState)
    abstract fun handleEvent(oldState: E, event: T)
}