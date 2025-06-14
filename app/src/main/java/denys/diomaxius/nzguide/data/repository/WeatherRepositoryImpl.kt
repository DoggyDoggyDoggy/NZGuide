package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.domain.model.DailyForecast
import denys.diomaxius.nzguide.domain.repository.WeatherRepository

class WeatherRepositoryImpl() : WeatherRepository  {
    override suspend fun getForecast(
        city: String,
        apiKey: String
    ): List<DailyForecast> {
        TODO("Not yet implemented")
    }
}