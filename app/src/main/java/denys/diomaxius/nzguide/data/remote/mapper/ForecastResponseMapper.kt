package denys.diomaxius.nzguide.data.remote.mapper

import denys.diomaxius.nzguide.data.remote.dto.ForecastResponse
import denys.diomaxius.nzguide.domain.model.weather.DailyForecast

fun ForecastResponse.toDailyForecastList(): List<DailyForecast> {
    return list.map { item ->
        DailyForecast(
            date = item.dtTxt,
            temp = item.main.temp,
            description = item.weather[0].description,
            icon = item.weather[0].icon
        )
    }
}