package denys.diomaxius.nzguide.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import denys.diomaxius.nzguide.domain.model.app.City

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val cities by viewModel.cities.collectAsState()

    LazyColumn {
        items(cities) {
            CityCard(city = it)
        }
    }
}

@Composable
fun CityCard(city: City) {
    Card {
        Text(text = city.cityName)
    }
}