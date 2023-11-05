package swerchansky.films.ui.events

import swerchansky.films.base.BaseUiEvent

sealed class FilmsUiEvent : BaseUiEvent() {
    object AddLoadingModels : FilmsUiEvent()
    data class LoadModelsPage(val page: Int = 1): FilmsUiEvent()
}