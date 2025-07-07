package denys.diomaxius.nzguide.data.local.mapper

import denys.diomaxius.nzguide.data.local.dto.CityDto
import denys.diomaxius.nzguide.domain.model.city.City
import denys.diomaxius.nzguide.domain.model.city.CityHistory

fun CityDto.toDomain(): City = City(
    id = id,
    name = cityName,
    photos = photo,
    places = emptyList(),
    history = CityHistory(emptyList())
)
