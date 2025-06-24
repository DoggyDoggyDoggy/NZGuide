package denys.diomaxius.nzguide.ui.screen.city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import denys.diomaxius.nzguide.ui.components.cityphotoslider.CityPhotoSlider
import denys.diomaxius.nzguide.ui.components.events.EventsRow
import denys.diomaxius.nzguide.ui.components.weather.WeatherForecastFiveDays
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import denys.diomaxius.nzguide.navigation.LocalNavController

@Composable
fun CityScreen(
    modifier: Modifier = Modifier,
    viewModel: CityScreenViewModel = hiltViewModel()
) {
    val city by viewModel.city.collectAsState()
    val navHostController = LocalNavController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CityPhotoSlider(
            modifier = Modifier
                .shadow(12.dp),
            city = city
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        WeatherForecastFiveDays(
            city = city
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        EventsRow(
            city = city,
            navHostController = navHostController
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        /*
        CityPlacesScreen(
            city = city
        )*/

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            CardTopThingsToDo(
                modifier = Modifier.weight(1f),
                cityName = city.cityName
            )
            CardTopThingsToDo(
                modifier = Modifier.weight(1f),
                cityName = city.cityName
            )
        }
    }
}

@Composable
fun CardTopThingsToDo(
    modifier: Modifier = Modifier,
    cityName: String) {
    Card(
        modifier = modifier
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            text = "Top Things to Do in $cityName City",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}












