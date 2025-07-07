package denys.diomaxius.nzguide.ui.screen.home

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import denys.diomaxius.nzguide.domain.model.city.City
import denys.diomaxius.nzguide.navigation.LocalNavController
import denys.diomaxius.nzguide.navigation.NavScreen
import denys.diomaxius.nzguide.ui.components.TextOverlay
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val cities by viewModel.cities.collectAsState()
    val navHostController = LocalNavController.current

    Scaffold (
      topBar = {
          TopBar(
              text = "City Guide"
          )
      }
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            navHostController = navHostController,
            cities = cities
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    cities: List<City>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(cities){
            CityCard(
                city = it,
                navHostController = navHostController
            )
        }

    }
}

@Composable
fun CityCard(
    city: City,
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val imageBitmap = remember {
        context.assets.open(city.photos.first()).use {
            BitmapFactory.decodeStream(it).asImageBitmap()
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                navHostController.navigate(
                    NavScreen.City.createRoute(city.id)
                ) {
                    launchSingleTop = true
                }
            }
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                bitmap = imageBitmap,
                contentDescription = city.name,
                contentScale = ContentScale.FillWidth
            )

            TextOverlay(text = city.name)
        }
    }
}