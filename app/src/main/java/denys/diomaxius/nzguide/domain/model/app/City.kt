package denys.diomaxius.nzguide.domain.model.app

data class City(
    val id: Int,
    val cityName: String,
    val photo: List<String>,
    val cityPlacesTopics: String
)

data class CityPlaceTopic(
    val title: String,
    val paragraph: String,
    val image: String
)