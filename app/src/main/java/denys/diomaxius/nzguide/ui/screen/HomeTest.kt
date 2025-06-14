package denys.diomaxius.nzguide.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HomeTest(
    viewModel: HomeTestViewModel = hiltViewModel()
) {
    val forecast by viewModel.forecast.collectAsState()
    val iconUrl = "https://openweathermap.org/img/wn/"

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        forecast.forEach {
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
                        model = iconUrl + it.icon + "@2x.png",
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
    val formatterOut = DateTimeFormatter.ofPattern("dd/MM")
    val dateTime = LocalDateTime.parse(date, formatterIn)
    val result = dateTime.format(formatterOut)
    return result
}