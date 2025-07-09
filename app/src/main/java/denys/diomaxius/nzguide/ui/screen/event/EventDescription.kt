package denys.diomaxius.nzguide.ui.screen.event

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.nzguide.domain.model.events.Event

@Composable
fun EventDescription(
    event: Event
) {
    Text(
        text = "Description:",
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = event.description,
        fontSize = 16.sp
    )
}