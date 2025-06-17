package denys.diomaxius.nzguide.domain.model.app

data class CityPhotoSlider(
    val photo: List<String>
)

val citiesPhotoSlider: Map<City, CityPhotoSlider> = mapOf(
    City.HAMILTON to CityPhotoSlider(
        photo = listOf(
            "hamilton/1.jpg",
            "hamilton/2.jpg",
            "hamilton/3.jpg"
        )
    ),
)
