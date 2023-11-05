package swerchansky.films.data.model

data class PageNetworkModel(
    val pagesCount: Int,
    val films: List<FilmNetworkModel>
)