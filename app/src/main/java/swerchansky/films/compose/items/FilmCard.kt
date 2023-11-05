package swerchansky.films.compose.items

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import swerchansky.films.R
import swerchansky.films.domain.model.FilmModel

@Composable
fun FilmCard(
    film: FilmModel
) {
    val textAdditional = "${film.genre ?: "???"}(${film.year ?: "???"})"
    val textFilmName = film.nameRu ?: "???"

    ElevatedCard(
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.background)),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(modifier = Modifier.padding(18.dp)) {
            Image(
                painter = rememberAsyncImagePainter(film.posterUrl),
                contentDescription = "film poster image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(60.dp)
                    .clip(RoundedCornerShape(14))
                    .fillMaxHeight()
            )
            Spacer(Modifier.width(18.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = textFilmName,
                    color = colorResource(R.color.film_name),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(24.dp)
                        .fillMaxWidth()
                )
                Spacer(Modifier.width(7.dp))
                Text(
                    text = textAdditional,
                    color = colorResource(R.color.film_additional),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(24.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
@Preview
fun ShimmerFilmCard(brush: Brush =  loadingShimmerBrush()) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.background)),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(modifier = Modifier.padding(18.dp)) {
            Spacer(
                modifier = Modifier
                    .width(60.dp)
                    .clip(RoundedCornerShape(14))
                    .fillMaxHeight()
                    .background(brush)
            )
            Spacer(Modifier.width(18.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.8f)
                        .background(brush)
                )
                Spacer(Modifier.height(7.dp))
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.5f)
                        .background(brush)
                )
            }
        }
    }
}

@Composable
fun loadingShimmerBrush(): Brush {
    val gradient = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition(label = "shimmer")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutLinearInEasing
            )
        ),
        label = "shimmer animation"
    )
    return Brush.linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
}