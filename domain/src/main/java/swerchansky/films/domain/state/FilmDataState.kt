package swerchansky.films.domain.state

sealed class FilmDataState<out T> {
    data class Success<out T>(val data: T) : FilmDataState<T>()
    data class Error(val exception: Exception) : FilmDataState<Nothing>()
    object Loading : FilmDataState<Nothing>()
}