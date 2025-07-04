package denys.diomaxius.nzguide.ui.screen.city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.navigation.LocalNavController
import denys.diomaxius.nzguide.navigation.NavScreen

@Composable
fun CityScreen(
    modifier: Modifier = Modifier,
    viewModel: CityScreenViewModel = hiltViewModel()
) {
    val city by viewModel.city.collectAsState()
    val navHostController = LocalNavController.current

    Scaffold { innerPadding ->
        Content(
            modifier = modifier.padding(innerPadding),
            city = city,
            navHostController = navHostController
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    city: City
) {
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            InfoCard(
                modifier = Modifier.weight(1f),
                cardText = "Top Things to Do in ${city.cityName} City",
                onClick = {
                    navHostController.navigate(
                        NavScreen.CityPlaces.createRoute(
                            cityPlacesJsonPath = city.cityPlacesTopics,
                            cityName = city.cityName
                        )
                    ) {
                        launchSingleTop = true
                    }
                }
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            InfoCard(
                modifier = Modifier.weight(1f),
                cardText = "City History",
                onClick = {
                    navHostController.navigate(
                        NavScreen.CityHistory.createRoute(
                            cityHistoryJsonPath = city.cityHistory
                        )
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}