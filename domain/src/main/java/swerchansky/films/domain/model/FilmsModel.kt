package swerchansky.films.domain.model

data class FilmModel (
    val filmId: Int? = null,
    val nameRu: String? = null,
    val year: String? = null,
    val genre: String? = null,
    val posterUrl: String? = null,
    val isDataLoading: Boolean = false
)