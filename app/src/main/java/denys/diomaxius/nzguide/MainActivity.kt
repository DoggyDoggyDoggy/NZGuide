package denys.diomaxius.nzguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import denys.diomaxius.nzguide.ui.screen.SliderDev
import denys.diomaxius.nzguide.ui.screen.citiesPhotoSlider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SliderDev(
                citiesPhotoSlider[0]
            )
        }
    }
}