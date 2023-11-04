package swerchansky.films.presentation.compose.screen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.presentation.R

class TitleProvider : PreviewParameterProvider<String> {
    override val values = listOf("Популярные").asSequence()
}

class FilmCardProvider : PreviewParameterProvider<FilmModel> {
    override val values = listOf(
        FilmModel(
            filmId = 10,
            nameRu = "Первому игроку приготовиться",
            year = "2023",
            genres = listOf("фантастика"),
            posterUrl = "",
        )
    ).asSequence()
}

@Composable
@Preview(device = Devices.PHONE)
fun FilmsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(top = 25.dp)
    ) {
        TopBar("Популярные")
        FilmsList(FilmCardProvider().values.toList())
    }
}

@Composable
@Preview
fun TopBar(
    @PreviewParameter(TitleProvider::class) barTitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 18.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = barTitle,
            color = colorResource(R.color.title),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.wrapContentHeight(Alignment.Bottom)
        )
        Image(
            painter = painterResource(R.drawable.search_image),
            contentDescription = "search",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(colorResource(R.color.search_icon)),
            modifier = Modifier
                .size(25.dp)
                .wrapContentHeight(Alignment.Bottom)
        )
    }
}

@Composable
@Preview
fun FilmCard(
    @PreviewParameter(FilmCardProvider::class) film: FilmModel
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.background)),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(modifier = Modifier.padding(18.dp)) {
            Card(
                shape = RoundedCornerShape(14)
            ) {
                Image(
                    painter = painterResource(R.drawable.film_poster_example),
                    contentDescription = "film poster image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(60.dp)
                        .fillMaxHeight()
                )
            }
            Spacer(Modifier.width(18.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = film.nameRu ?: "???",
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
                    text = film.genres?.get(0) ?: "???",
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
fun FilmsList(films: List<FilmModel>) {
    LazyColumn(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        items(films) { film ->
            Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                FilmCard(film)
            }
        }
    }
}

