package denys.diomaxius.nzguide.data.repository

import denys.diomaxius.nzguide.data.local.datasource.CityAssetsSource
import denys.diomaxius.nzguide.data.local.mapper.toDomain
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.app.CityHistory
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import denys.diomaxius.nzguide.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val allCities: List<City>,
    private val cityAssetsSource: CityAssetsSource
) : CityRepository {
    override fun getAllCities(): List<City> = allCities

    override fun getCityById(id: Int): City = allCities.find { it.id == id }!!

    override fun getCityPlaces(cityPlaces: String): List<CityPlaceTopic> {
        return cityAssetsSource.loadCityPlacesJson(cityPlaces).toDomain()
    }

    override fun getCityHistory(cityHistory: String): CityHistory {
        return cityAssetsSource.loadCityHistoryJson(cityHistory).toDomain()
    }
}