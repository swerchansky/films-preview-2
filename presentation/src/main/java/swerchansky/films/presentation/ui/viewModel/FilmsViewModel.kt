package swerchansky.films.presentation.ui.viewModel

import swerchansky.films.presentation.base.BaseViewModel
import swerchansky.films.presentation.ui.intent.FilmsIntent

class FilmsViewModel: BaseViewModel<FilmsIntent>() {
    lateinit var title: String

    override fun onEvent(eventType: FilmsIntent) {
        TODO("Not yet implemented")
    }
}