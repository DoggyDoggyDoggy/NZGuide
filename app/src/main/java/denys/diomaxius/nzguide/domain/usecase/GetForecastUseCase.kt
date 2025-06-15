package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.model.DailyForecast
import denys.diomaxius.nzguide.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(city: String, apiKey: String) : List<DailyForecast> {
        return weatherRepository.getForecast(city, apiKey).filter {
            it.date.contains("12:00:00")
        }
    }
}