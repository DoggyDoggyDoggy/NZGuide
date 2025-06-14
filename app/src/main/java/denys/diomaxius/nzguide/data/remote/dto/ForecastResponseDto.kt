package denys.diomaxius.nzguide.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("list") val list: List<ForecastItem>
)

data class ForecastItem(
    @SerializedName("dt_txt") val dtTxt: String,
    @SerializedName("main") val main: MainInfo,
    @SerializedName("weather") val weather: List<WeatherInfo>
)

data class MainInfo(
    @SerializedName("temp") val temp: Double
)

data class WeatherInfo(
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)