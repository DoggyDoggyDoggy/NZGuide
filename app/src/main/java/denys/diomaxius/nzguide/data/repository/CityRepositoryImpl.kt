package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.data.local.datasource.CityAssetsSource
import denys.diomaxius.nzguide.data.local.dto.CityDto
import denys.diomaxius.nzguide.data.local.mapper.toDomain
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val cityDto: List<CityDto>,
    private val cityAssetsSource: CityAssetsSource
) : CityRepository {
    override fun getAllCities(): List<City> = cityDto.map {
        it.toDomain()
    }

    override fun getCityById(id: Int): City {
        val dto = cityDto.find { it.id == id }!!
        val places = cityAssetsSource.loadCityPlacesJson(dto.cityPlacesTopics).toDomain()
        val history = cityAssetsSource.loadCityHistoryJson(dto.cityHistory).toDomain()
        return City(
            id = dto.id,
            name = dto.cityName,
            photos = dto.photo,
            places = places,
            history = history
        )
    }
}