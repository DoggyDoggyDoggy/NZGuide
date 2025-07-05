package denys.diomaxius.nzguide.domain.model.app

data class City(
    val id: Int,
    val cityName: String,
    val photo: List<String>,
    val cityPlacesTopics: String,
    val cityHistory: String
)

data class CityPlaceTopic(
    val title: String,
    val paragraph: String,
    val image: String
)

data class CityHistory(
    val paragraphs: List<String>
)