package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class GetAllCitiesUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    operator fun invoke(): List<City> = cityRepository.getAllCities()
}