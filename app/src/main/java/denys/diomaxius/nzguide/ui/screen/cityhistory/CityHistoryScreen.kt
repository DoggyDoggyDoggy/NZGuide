package denys.diomaxius.nzguide.ui.screen.cityhistory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.nzguide.domain.model.city.CityHistory
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun CityHistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CityHistoryScreenViewModel = hiltViewModel()
) {
    val cityHistory by viewModel.cityHistory.collectAsState()
    val cityName by viewModel.cityName.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                text = "History of $cityName"
            )
        }
    ) { innerPadding ->
        Content(
            modifier = modifier.padding(innerPadding),
            cityHistory = cityHistory
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    cityHistory: CityHistory
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        cityHistory.paragraphs.forEach {
            Text(
                text = it,
                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}