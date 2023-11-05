package swerchansky.films.data.repository

import swerchansky.films.data.mapper.NetworkModelMapper.toFilmModels
import swerchansky.films.data.network.APIService
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.domain.repository.PopularFilmsRepository
import javax.inject.Inject

class FilmsNetworkRepository @Inject constructor(
    private val service: APIService,
) : PopularFilmsRepository<@JvmSuppressWildcards List<FilmModel>> {
    override suspend fun getTopFilms(page: Int) =
        service.getTopFilms(page)
            .execute()
            .body()
            ?.toFilmModels()
            ?: emptyList()
}