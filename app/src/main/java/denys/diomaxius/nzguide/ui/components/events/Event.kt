package denys.diomaxius.nzguide.ui.components.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Event(
    val name: String
)

val events = listOf<Event>(
    Event(
        name = "LONG NAME OF THE EVENT LONG NAME OF THE EVENT"
    ),
    Event(
        name = "Events"
    ),
    Event(
        name = "Events"
    )
)

@Composable
fun EventsRow(modifier: Modifier = Modifier) {
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

        LazyRow {
            items(events) {
                EventCard(it)
            }
        }
    }
}

@Composable
fun EventCard(
    event: Event
) {
    Card(
        modifier = Modifier
            .padding(start = 12.dp)
            .size(175.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(175.dp, 130.dp)
                    .background(Color.Cyan)
            ) { }
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