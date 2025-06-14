package denys.diomaxius.nzguide.data.remote.api

import denys.diomaxius.nzguide.data.remote.dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ) : ForecastResponse
}