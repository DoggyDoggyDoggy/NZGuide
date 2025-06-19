package denys.diomaxius.nzguide.domain.usecase

import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class GetCityByIdUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    operator fun invoke(id: Int) = cityRepository.getCityById(id)
}