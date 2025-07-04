package denys.diomaxius.nzguide.domain.repository

import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.app.CityHistory
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic

interface CityRepository {
    fun getAllCities(): List<City>
    fun getCityById(id: Int) : City
    fun getCityPlaces(cityPlaces: String) : List<CityPlaceTopic>
    fun getCityHistory(cityPlaces: String) : CityHistory
}