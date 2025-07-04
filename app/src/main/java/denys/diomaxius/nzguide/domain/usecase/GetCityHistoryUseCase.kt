package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class GetCityHistoryUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    operator fun invoke(cityHistory: String) = cityRepository.getCityHistory(cityHistory)
}