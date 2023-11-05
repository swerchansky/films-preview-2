package swerchansky.films.data.model

import android.graphics.Bitmap

data class FilmNetworkModel(
    val filmId: Int,
    val nameRu: String?,
    val year: String?,
    val genres: List<GenreNetworkModel>,
    val posterUrlPreview: String,
    var posterImagePreview: Bitmap? = null,
)