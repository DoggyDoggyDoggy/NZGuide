package denys.diomaxius.nzguide.data.local.dto

import kotlinx.serialization.Serializable

@Serializable
data class CityDto(
    val id: Int,
    val cityName: String,
    val photo: List<String>,
    val cityPlacesTopics: String,
    val cityHistory: String
)

@Serializable
data class CitiesDto(
    val cities: List<CityDto>
)