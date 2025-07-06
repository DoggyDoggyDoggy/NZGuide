package denys.diomaxius.nzguide.ui.components.cityphotoslider

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import denys.diomaxius.nzguide.domain.model.app.City
import denys.diomaxius.nzguide.ui.components.TextOverlay

@Composable
fun CityPhotoSlider(
    modifier: Modifier = Modifier,
    city: City
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        AutoScrollPager(
            items = city.photos,
            modifier = Modifier
                .fillMaxWidth()
        ) { assetPath ->
            AssetImage(assetPath)
        }

        TextOverlay(city.name)
    }
}

@Composable
fun AssetImage(
    assetPath: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageBitmap = remember(assetPath) {
        val inputStream = context.assets.open(assetPath)
        BitmapFactory.decodeStream(inputStream)
    }

    Image(
        modifier = modifier.fillMaxWidth(),
        bitmap = imageBitmap.asImageBitmap(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}