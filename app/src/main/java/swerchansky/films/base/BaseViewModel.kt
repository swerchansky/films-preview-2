package swerchansky.films.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import swerchansky.films.domain.base.BaseState

abstract class BaseViewModel<T : BaseUiEvent, E : BaseState> : ViewModel() {
    abstract val state: Flow<E>
}