package denys.diomaxius.nzguide.domain.model

data class DailyForecast(
    val date: String,
    val temp: Double,
    val description: String,
    val icon: String
)