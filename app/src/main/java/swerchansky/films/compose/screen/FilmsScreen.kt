package swerchansky.films.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import swerchansky.films.R
import swerchansky.films.compose.items.FilmCard
import swerchansky.films.compose.items.ShimmerFilmCard
import swerchansky.films.compose.items.TopBar
import swerchansky.films.domain.model.FilmModel
import swerchansky.films.ui.viewModel.FilmsViewModel

@Composable
fun FilmsScreen(viewModel: FilmsViewModel) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(top = 25.dp)
    ) {
        TopBar(
            barTitle = stringResource(R.string.barTitle),
        )
        FilmsList(state.data ?: emptyList())
    }
}

@Composable
fun FilmsList(films: List<FilmModel>) {
    LazyColumn(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        items(films) { film ->
            Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                when (film.isDataLoading) {
                    true -> ShimmerFilmCard()
                    else -> FilmCard(film)
                }
            }
        }
    }
}
