package denys.diomaxius.nzguide.ui.screen.cityhistory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityHistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CityHistoryScreenViewModel = hiltViewModel()
) {
    val cityHistory by viewModel.cityHistory.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCityHistory()
    }

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