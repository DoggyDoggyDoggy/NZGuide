package denys.diomaxius.nzguide.ui.screen.event

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzevents.ui.screen.event.EventDetailsScreenViewModel
import denys.diomaxius.nzguide.navigation.LocalNavController
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun EventDetailsScreen(
    viewModel: EventDetailsScreenViewModel = hiltViewModel()
) {
    val event by viewModel.event.collectAsState()
    val context: Context = LocalContext.current
    val navHostController = LocalNavController.current

    if (event.id == "API Error") {
        ErrorLoadEvent()
    } else if (event.id != "") {
        Scaffold(
            topBar = {
                TopBar(
                    text = "Event Details",
                    navHostController = navHostController
                )
            },
            bottomBar = {
                BuyTicketButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .padding(vertical = 8.dp)
                        .height(50.dp),
                    event = event,
                    context = context
                )
            }
        ) { innerPadding ->
            Content(
                modifier = Modifier.padding(innerPadding),
                event = event
            )
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    event: Event
) {
    Card(
        modifier = modifier
            .padding(top = 12.dp)
            .padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = event.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                model = event.images.images[0].transforms.transforms.last().url,
                contentScale = ContentScale.FillWidth,
                contentDescription = "Image"
            )

            Spacer(modifier = Modifier.height(6.dp))

            EventDescription(event)

            Spacer(modifier = Modifier.height(12.dp))

            EventAddress(event)
            Spacer(modifier = Modifier.height(4.dp))
            EventDates(event)
        }
    }
}