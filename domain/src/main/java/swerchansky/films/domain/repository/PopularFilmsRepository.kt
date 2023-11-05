package swerchansky.films.domain.repository

interface PopularFilmsRepository<T> {
    suspend fun getTopFilms(page: Int = 1): T
}