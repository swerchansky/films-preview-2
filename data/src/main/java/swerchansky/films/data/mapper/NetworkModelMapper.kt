package swerchansky.films.data.mapper

import swerchansky.films.data.model.PageNetworkModel
import swerchansky.films.domain.model.FilmModel

object NetworkModelMapper {
    fun PageNetworkModel.toFilmModels(): List<FilmModel> {
        val default = "???"
        return films.map {
            FilmModel(
                filmId = it.filmId,
                nameRu = it.nameRu ?: default,
                year = it.year ?: default,
                genre = it.genres.firstOrNull()?.genre ?: default,
                posterUrl = it.posterUrlPreview,
                isDataLoading = false
            )
        }
    }
}