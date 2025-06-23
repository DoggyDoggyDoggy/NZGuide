package denys.diomaxius.nzguide.data.local.mapper

import denys.diomaxius.nzguide.data.local.dto.CityPlacesDto
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic

fun CityPlacesDto.toDomain(): List<CityPlaceTopic> =
    cityPlacesTopics.map {
        CityPlaceTopic(it.title, it.paragraph, it.image)
    }