package denys.diomaxius.nzguide.domain.repository

import denys.diomaxius.nzguide.domain.model.city.City

interface CityRepository {
    fun getAllCities(): List<City>
    fun getCityById(id: Int) : City
}