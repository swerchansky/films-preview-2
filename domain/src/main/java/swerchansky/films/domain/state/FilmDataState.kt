package swerchansky.films.domain.state

import swerchansky.films.domain.base.BaseState

data class FilmDataState<out T>(
    val data: T?
) : BaseState() {
    companion object {
        fun <T> initial(): FilmDataState<T> = FilmDataState(data = null)
    }
}