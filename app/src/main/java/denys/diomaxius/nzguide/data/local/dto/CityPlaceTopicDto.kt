package denys.diomaxius.nzguide.data.local.dto

import kotlinx.serialization.Serializable

@Serializable
data class CityPlaceTopicDto(
    val title: String,
    val paragraph: String
)

@Serializable
data class CityPlacesDto(
    val cityPlacesTopics: List<CityPlaceTopicDto>
)