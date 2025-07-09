package denys.diomaxius.nzguide.ui.screen.event

import android.content.Context
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.core.net.toUri
import denys.diomaxius.nzevents.ui.screen.event.EventDetailsScreenViewModel
import denys.diomaxius.nzguide.ui.components.topbar.TopBar

@Composable
fun EventDetailsScreen(
    viewModel: EventDetailsScreenViewModel = hiltViewModel()
) {
    val event by viewModel.event.collectAsState()
    val context: Context = LocalContext.current

    if(event.id == "API Error") {
        ErrorLoadEvent()
    } else if (event.id != "") {
        Scaffold(
            topBar = {
                TopBar(
                    text = "Event Details"
                )
            },
            bottomBar = {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .height(50.dp),
                    onClick = {
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW, event.url.toUri())
                        )
                    }
                ) {
                    Text(
                        text = "Buy Tickets",
                        fontSize = 20.sp
                    )
                }
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

        Spacer(modifier = Modifier.height(24.dp))

        EventDescription(event)

        Spacer(modifier = Modifier.height(24.dp))

        EventAddress(event)

        EventDates(event)
    }
}

@Composable
fun EventDates(
    event: Event
) {
    var expanded by remember { mutableStateOf(false) }

    event.sessions
        .sessions
        .getOrNull(0)
        ?.datetimeSummary
        ?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date"
                )
                Text(
                    text = it,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(12.dp))

                if (event.sessions.sessions.size > 1){
                    Icon(
                        modifier = Modifier.clickable {
                            expanded = !expanded
                        },
                        imageVector =
                            if (!expanded) Icons.Default.KeyboardArrowDown
                            else Icons.Default.KeyboardArrowUp,
                        contentDescription = "Date"
                    )
                }
            }
        }

    AnimatedVisibility(
        visible = expanded,
        enter = expandVertically(
            animationSpec = tween(durationMillis = 350)
        ),
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = 350)
        )
    ) {
        LazyColumn {
            items(event.sessions.sessions.drop(1)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date"
                    )

                    Text(
                        text = it.datetimeSummary,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}