package swerchansky.films.domain.model

data class FilmModel (
    val filmId: Int,
    val nameRu: String?,
    val year: String?,
    val genres: List<String>?,
    val posterUrl: String,
)