package denys.diomaxius.nzguide.ui.screen.city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import denys.diomaxius.nzguide.ui.components.cityphotoslider.CityPhotoSlider
import denys.diomaxius.nzguide.ui.components.cityphotoslider.citiesPhotoSlider
import denys.diomaxius.nzguide.ui.components.weather.WeatherForecastFiveDays

@Composable
fun CityScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CityPhotoSlider(
            modifier = Modifier
                .shadow(12.dp),
            city = citiesPhotoSlider[0]
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        WeatherForecastFiveDays()
    }
}