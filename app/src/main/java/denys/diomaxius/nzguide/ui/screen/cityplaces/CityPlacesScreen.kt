package denys.diomaxius.nzguide.ui.screen.cityplaces

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import denys.diomaxius.nzguide.domain.model.city.CityPlaceTopic
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun CityPlacesScreen(
    viewModel: CityPlacesScreenViewModel = hiltViewModel()
) {
    val cityPlacesTopics by viewModel.cityPlaces.collectAsState()
    val cityName by viewModel.cityName.collectAsState()

    Scaffold(
        topBar = {
            TopBar("Top Things to Do in $cityName")
        }
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            cityPlacesTopics = cityPlacesTopics
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    cityPlacesTopics: List<CityPlaceTopic>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(cityPlacesTopics) { topic ->
            CityPlace(topic)
        }
    }
}

@Composable
fun CityPlace(topic: CityPlaceTopic) {
    Card (
        modifier = Modifier.padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ){
        Column (
          modifier = Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = topic.title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            if (topic.image != "") {
                AssetImage(topic.image)
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
            }

            Text(
                text = topic.paragraph,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun AssetImage(
    assetPath: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageBitmap = remember(assetPath) {
        val inputStream = context.assets.open(assetPath)
        BitmapFactory.decodeStream(inputStream)
    }

    Image(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
        bitmap = imageBitmap.asImageBitmap(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}