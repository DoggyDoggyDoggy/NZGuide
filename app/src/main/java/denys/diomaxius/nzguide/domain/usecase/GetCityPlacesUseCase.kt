package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class GetCityPlacesUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    operator fun invoke(cityPlaces: String) = cityRepository.getCityPlaces(cityPlaces)
}