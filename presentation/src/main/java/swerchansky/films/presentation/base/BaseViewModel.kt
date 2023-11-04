package swerchansky.films.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.domain.state.FilmDataState

abstract class BaseViewModel<T : BaseIntent, E : FilmDataState<List<FilmModel>>> : ViewModel() {
    abstract val state: Flow<E>

    abstract fun onEvent(eventType: T)
}