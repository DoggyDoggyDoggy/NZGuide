package denys.diomaxius.nzguide.ui.screen.event

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import denys.diomaxius.nzguide.domain.model.events.Event

@Composable
fun BuyTicketButton(
    modifier: Modifier = Modifier,
    event: Event,
    context: Context
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(bottom = 8.dp)
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