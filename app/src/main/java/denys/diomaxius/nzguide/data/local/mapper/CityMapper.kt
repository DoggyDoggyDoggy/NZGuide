package denys.diomaxius.nzguide.data.local.mapper

import denys.diomaxius.nzguide.data.local.dto.CitiesDto
import denys.diomaxius.nzguide.domain.model.app.City

fun CitiesDto.toDomain(): List<City> = cities.map {
    City(it.id, it.cityName, it.photo, it.cityPlacesTopics, it.cityHistory)
}