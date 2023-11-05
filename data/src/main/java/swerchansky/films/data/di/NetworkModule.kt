package swerchansky.films.data.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import swerchansky.films.data.base.Config
import swerchansky.films.data.network.APIService

@Module
class NetworkModule {
    @Provides
    fun provideMapper(): ObjectMapper {
        return JsonMapper
            .builder()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build()
            .registerModule(KotlinModule.Builder().build())
    }

    @Provides
    fun provideApiService(): APIService {
        return Retrofit.Builder()
            .baseUrl(Config.URL)
            .addConverterFactory(JacksonConverterFactory.create(provideMapper()))
            .build()
            .create(APIService::class.java)
    }
}