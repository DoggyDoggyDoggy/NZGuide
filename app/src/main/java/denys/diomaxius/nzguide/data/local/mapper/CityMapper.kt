package denys.diomaxius.nzguide.data.local.mapper

import denys.diomaxius.nzguide.data.local.dto.CityDto
import denys.diomaxius.nzguide.domain.model.app.City

fun CityDto.toDomain(): City = City(
    id = id,
    cityName = cityName,
    photo = photo,
    cityPlacesTopics = cityPlacesTopics,
    cityHistory = cityHistory
)