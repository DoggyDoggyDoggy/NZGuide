package denys.diomaxius.nzguide.ui.components.cityplaces

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityPlacesScreen() {
    CityPlace()
}

@Composable
fun CityPlace() {
    Text(
        text = "Title"
    )

    Spacer(
        modifier = Modifier.height(5.dp)
    )

    Text(
        text = "Paragraph"
    )
}