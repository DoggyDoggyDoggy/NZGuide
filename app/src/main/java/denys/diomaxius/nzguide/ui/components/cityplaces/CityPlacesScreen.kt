package denys.diomaxius.nzguide.ui.components.cityplaces

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.domain.model.app.CityPlacesWrapper
import denys.diomaxius.nzguide.domain.model.app.CityPlaceTopic
import kotlinx.serialization.json.Json

@Composable
fun CityPlacesScreen(city: City) {
    val context = LocalContext.current
    val cityPlacesTopics = loadTopics(context, city.cityPlacesTopics)
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

fun loadTopics(context: Context, fileName: String): List<CityPlaceTopic> {
    val json = context.assets.open(fileName)
        .bufferedReader()
        .use { it.readText() }

    return Json { ignoreUnknownKeys = true }
        .decodeFromString<CityPlacesWrapper>(json)
        .cityPlacesTopics
}