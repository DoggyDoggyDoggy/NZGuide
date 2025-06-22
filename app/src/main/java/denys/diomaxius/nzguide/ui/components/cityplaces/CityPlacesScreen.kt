package denys.diomaxius.nzguide.ui.components.cityplaces

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import androidx.compose.runtime.getValue

@Composable
fun CityPlacesScreen(
    city: City,
    viewModel: CityPlacesScreenViewModel = hiltViewModel()
) {
    val cityPlacesTopics by viewModel.cityPlaces.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCityPlaces(city.cityPlacesTopics)
    }

    LazyColumn {
        items(cityPlacesTopics) {
            CityPlace(it)
        }
    }
}

@Composable
fun CityPlace(topic: CityPlaceTopic) {
    Text(
        text = topic.title
    )

    Spacer(
        modifier = Modifier.height(5.dp)
    )

    Text(
        text = topic.paragraph
    )
}