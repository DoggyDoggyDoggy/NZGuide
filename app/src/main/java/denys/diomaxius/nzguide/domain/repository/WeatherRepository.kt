package denys.diomaxius.nzguide.domain.repository

import denys.diomaxius.nzguide.domain.model.DailyForecast

interface WeatherRepository {
    suspend fun getForecast(city: String, apiKey: String): List<DailyForecast>
}