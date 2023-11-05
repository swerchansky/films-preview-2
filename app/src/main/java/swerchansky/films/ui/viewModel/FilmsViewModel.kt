package swerchansky.films.ui.viewModel

import swerchansky.films.base.BaseViewModel
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.domain.state.FilmDataState
import swerchansky.films.ui.events.FilmsUiEvent
import swerchansky.films.ui.handlers.FilmsEventHandler
import javax.inject.Inject

class FilmsViewModel @Inject constructor(
    private val eventHandler: FilmsEventHandler
) : BaseViewModel<FilmsUiEvent, FilmDataState<List<FilmModel>>>() {
    override val state get() = eventHandler.state

    init {
        with(eventHandler) {
            sendEvent(FilmsUiEvent.AddLoadingModels)
            sendEvent(FilmsUiEvent.LoadModelsPage())
        }
    }
}