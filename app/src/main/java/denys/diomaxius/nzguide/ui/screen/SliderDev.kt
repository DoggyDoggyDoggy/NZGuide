package denys.diomaxius.nzguide.ui.screen

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import denys.diomaxius.nzguide.domain.model.CityPhotoSlider


@Composable
fun SliderDev(
    city: CityPhotoSlider
) {
    val pagerState = rememberPagerState(
        pageCount = {
            city.photo.size
        }
    )

    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        state = pagerState
    ) {
        AssetImage(
            assetPath = city.photo[it]
        )
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
