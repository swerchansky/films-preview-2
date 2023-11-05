package swerchansky.films.ui.handlers

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import swerchansky.films.base.BaseEventHandler
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.domain.repository.PopularFilmsRepository
import swerchansky.films.domain.state.FilmDataState
import swerchansky.films.ui.events.FilmsUiEvent
import swerchansky.films.ui.events.FilmsUiEvent.AddLoadingModels
import swerchansky.films.ui.events.FilmsUiEvent.LoadModelsPage
import javax.inject.Inject

class FilmsEventHandler @Inject constructor(
    private val repository: PopularFilmsRepository<List<FilmModel>>,
    private val lifecycleCoroutineScope: LifecycleCoroutineScope,
    private val dispatcher: CoroutineDispatcher,

) : BaseEventHandler<FilmsUiEvent, FilmDataState<List<FilmModel>>>(FilmDataState.initial()) {
    override fun handleEvent(oldState: FilmDataState<List<FilmModel>>, event: FilmsUiEvent) {
        when (event) {
            is AddLoadingModels -> {
                val loadingModels = (0..5).map { FilmModel(isDataLoading = true) }
                val newState = oldState.copy(
                    data = (oldState.data ?: emptyList()) + loadingModels
                )
                setState(newState)
            }
            is LoadModelsPage -> {
                lifecycleCoroutineScope.launch(dispatcher) {
                    val films = repository.getTopFilms(event.page)
                    setState(oldState.copy(data = films))
                }
            }
        }
    }
}