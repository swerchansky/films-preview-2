package swerchansky.films.data.di

import dagger.Binds
import dagger.Module
import swerchansky.films.data.repository.FilmsNetworkRepository
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.domain.repository.PopularFilmsRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: FilmsNetworkRepository): PopularFilmsRepository<List<FilmModel>>
}