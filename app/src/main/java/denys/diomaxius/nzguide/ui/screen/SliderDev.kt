package denys.diomaxius.nzguide.ui.screen

import android.graphics.BitmapFactory
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.nzguide.domain.model.CityPhotoSlider
import kotlinx.coroutines.delay

@Composable
fun SliderDev(
    city: CityPhotoSlider
) {
    Box(
        contentAlignment = Alignment.BottomStart
    ) {
        AutoScrollPager(
            items = city.photo,
            modifier = Modifier
                .fillMaxWidth()
        ) { assetPath ->
            AssetImage(assetPath)
        }

        TextOverlay(city.city)
    }
}

@Composable
fun AutoScrollPager(
    items: List<String>,
    modifier: Modifier = Modifier,
    intervalMs: Long = 4000L,
    animationMillis: Int = 1000,
    pageContent: @Composable (String) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { items.size })

    LaunchedEffect(pagerState) {
        var goingForward = true
        while (true) {
            delay(intervalMs)
            val next = when {
                goingForward && pagerState.currentPage < items.lastIndex -> pagerState.currentPage + 1
                !goingForward && pagerState.currentPage > 0 -> pagerState.currentPage - 1
                else -> {
                    goingForward = !goingForward
                    pagerState.currentPage + if (goingForward) 1 else -1
                }
            }
            pagerState.animateScrollToPage(
                page = next,
                animationSpec = tween(
                    durationMillis = animationMillis,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        userScrollEnabled = false,
        modifier = modifier
    ) { page ->
        pageContent(items[page])
    }
}

@Composable
fun TextOverlay(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Black.copy(alpha = 0.3f))
            .padding(start = 5.dp, end = 6.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp,
            color = Color.White
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