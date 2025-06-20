package denys.diomaxius.nzguide.ui.components.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.util.Resource
import denys.diomaxius.nzguide.domain.model.weather.DailyForecast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

private const val ICON_BASE_URL = "https://openweathermap.org/img/wn/"

@Composable
fun WeatherForecastFiveDays(
    viewModel: WeatherForecastFiveDaysViewModel = hiltViewModel(),
    city: City
) {
    val forecastState by viewModel.forecastState.collectAsState()

    LaunchedEffect(city) {
        viewModel.getForecast(
            city = city.cityName+",NZ"
        )
    }

    when(forecastState) {
        is Resource.Error -> {}
        is Resource.Loading -> {
            LoadingWeather()
        }
        is Resource.Success -> {
            LoadedWeather(forecastState = (forecastState as Resource.Success).data)
        }

    }
}

@Composable
fun LoadingWeather() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(5) {
            Card (
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Box(Modifier.fillMaxWidth().height(70.dp)) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun LoadedWeather(forecastState: List<DailyForecast>) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        forecastState.forEach {
            Card (
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(dateFormatter(it.date))

                    AsyncImage(
                        model = ICON_BASE_URL + it.icon + "@2x.png",
                        contentDescription = "Icon"

                    )

                    Text(
                        text = "${it.temp.toInt()} °C"
                    )
                }
            }
        }
    }
}

fun dateFormatter(date: String) : String {
    val formatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formatterOut = DateTimeFormatter.ofPattern("dd MMM", Locale.ENGLISH)
    val dateTime = LocalDateTime.parse(date, formatterIn)
    val result = dateTime.format(formatterOut)
    return result
}