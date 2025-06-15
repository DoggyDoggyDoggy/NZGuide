package denys.diomaxius.nzguide.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeTest(
    viewModel: HomeTestViewModel = hiltViewModel()
) {
    val forecast by viewModel.forecast.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(forecast) {
            Text(it.temp.toString())
        }
    }
}