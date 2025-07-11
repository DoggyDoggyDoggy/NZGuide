package denys.diomaxius.nzguide.domain.model.city

data class City(
    val id: Int,
    val name: String,
    val photos: List<String>,
    val places: List<CityPlaceTopic>,
    val history: CityHistory
)