package denys.diomaxius.nzguide.ui.components.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import denys.diomaxius.nzguide.domain.model.city.City
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzguide.navigation.NavScreen

@Composable
fun EventsRow(
    modifier: Modifier = Modifier,
    viewModel: EventsRowViewModel = hiltViewModel(),
    city: City,
    navHostController: NavHostController
) {
    val eventsPager = viewModel.eventsPager.collectAsLazyPagingItems()

    LaunchedEffect(city) {
        viewModel.setLocationFilter(city.id)
        viewModel.setWeekDate()
    }

    Content(
        modifier = modifier,
        eventsPager = eventsPager,
        navHostController = navHostController
    )

}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    eventsPager: LazyPagingItems<Event>,
    navHostController: NavHostController
) {
    val loadState = eventsPager.loadState

    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier.padding(horizontal = 12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Events",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        }

        Spacer(
            modifier = Modifier.size(10.dp)
        )

        if (loadState.refresh is LoadState.Loading) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LoadingCard()
                LoadingCard()
            }
        } else {
            LazyRow {
                items(count = eventsPager.itemCount) { index ->
                    val event = eventsPager[index]
                    EventCard(
                        event = event!!,
                        navHostController = navHostController
                    )
                }

                if (loadState.append is LoadState.Loading) {
                    item {
                        LoadingCard()
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingCard() {
    Card(
        modifier = Modifier
            .padding(start = 12.dp)
            .size(175.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(130.dp)
                    .padding(top = 8.dp),
                strokeWidth = 10.dp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Loading...",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun EventCard(
    event: Event,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(start = 12.dp)
            .size(175.dp)
            .clickable{
                navHostController.navigate(NavScreen.Event.createRoute(event.id)) {
                    launchSingleTop = true
                }
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.size(175.dp, 130.dp),
                model = event.images.images[0].transforms.transforms.last().url,
                contentScale = ContentScale.FillBounds,
                contentDescription = "Event image"
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .padding(top = 4.dp),
                    text = event.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}