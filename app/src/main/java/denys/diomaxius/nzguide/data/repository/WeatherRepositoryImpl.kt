package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.data.remote.api.WeatherApi
import denys.diomaxius.nzguide.data.remote.mapper.toDailyForecastList
import denys.diomaxius.nzguide.domain.model.weather.DailyForecast
import denys.diomaxius.nzguide.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApi
) : WeatherRepository  {
    override suspend fun getForecast(
        city: String,
        apiKey: String
    ): List<DailyForecast> = apiService.getForecast(city, apiKey).toDailyForecastList()
}