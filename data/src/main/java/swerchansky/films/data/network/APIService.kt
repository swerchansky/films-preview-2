package swerchansky.films.data.network

import retrofit2.Call
import retrofit2.http.*
import swerchansky.films.data.base.Config
import swerchansky.films.data.model.PageNetworkModel

interface APIService {
   @Headers("X-API-KEY: ${Config.API_TOKEN_KEY}")
   @GET("api/v2.2/films/top")
   fun getTopFilms(
      @Query("page") page: Int,
      @Query("type") type: String = Config.TOP_TYPE_GET_PARAMETER
   ): Call<PageNetworkModel>
}