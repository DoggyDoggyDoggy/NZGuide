package denys.diomaxius.nzguide.data.local.dto

import kotlinx.serialization.Serializable

@Serializable
data class CityHistoryDto (
    val paragraphs: List<String>
)