package denys.diomaxius.nzguide.ui.screen.event

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import denys.diomaxius.nzguide.domain.model.events.Event
import denys.diomaxius.nzevents.ui.screen.event.EventDetailsScreenViewModel
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun EventDetailsScreen(
    viewModel: EventDetailsScreenViewModel = hiltViewModel()
) {
    val event by viewModel.event.collectAsState()
    val context: Context = LocalContext.current

    if (event.id == "API Error") {
        ErrorLoadEvent()
    } else if (event.id != "") {
        Scaffold(
            topBar = {
                TopBar(
                    text = "Event Details"
                )
            },
            bottomBar = {
                BuyTicketButton(
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = event.name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = event.images.images[0].transforms.transforms.last().url,
            contentScale = ContentScale.FillWidth,
            contentDescription = "Image"
        )

        Spacer(modifier = Modifier.height(8.dp))

        EventDescription(event)

        Spacer(modifier = Modifier.height(24.dp))

        EventAddress(event)

        EventDates(event)
    }
}

@Composable
fun EventDates(event: Event) {
    val sessions = event.sessions.sessions
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = null
        )

        if (!expanded) {
            Text(
                text = sessions.firstOrNull()?.datetimeSummary.orEmpty(),
                fontSize = 16.sp,
            )
        } else {
            LazyColumn {
                items(sessions) { session ->
                    Text(
                        text = session.datetimeSummary,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                    )
                }
            }
        }

        if (sessions.size > 1) {
            Icon(
                modifier = Modifier
                    .clickable { expanded = !expanded },
                imageVector = if (expanded)
                    Icons.Default.KeyboardArrowUp
                else
                    Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) "Hide dates" else "Show dates"
            )
        }

        Spacer(modifier = Modifier.width(20.dp))
    }
}
