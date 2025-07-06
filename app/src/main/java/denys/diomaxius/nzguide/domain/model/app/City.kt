package denys.diomaxius.nzguide.domain.model.app

data class City(
    val id: Int,
    val name: String,
    val photos: List<String>,
    val places: String,
    val history: String
)

data class CityPlaceTopic(
    val title: String,
    val paragraph: String,
    val image: String
)

data class CityHistory(
    val paragraphs: List<String>
)