package com.example.mymovieapp.screen.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.mymovieapp.model.MovieItemUiModel
import com.example.mymovieapp.utils.PLACEHOLDER_IMAGE_URL

@ExperimentalCoilApi
@Composable
fun MovieListScreen(viewModel: MovieListViewModel) {
    MovieList(modifier = Modifier, movieList = viewModel.movieList)
}


@Composable
fun MovieList(
    modifier: Modifier,
    movieList: List<MovieItemUiModel>

) {
    LazyColumn(modifier = modifier) {
        items(movieList) {
            MovieItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                item = it
            )
        }
    }
}


@Composable
fun MovieItem(
    modifier: Modifier,
    item: MovieItemUiModel
) {
    MovieCard(
        modifier = modifier,
        elevation = 2.dp,
        shape = small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    top = 16.dp,
                    bottom = 16.dp,
                    end = 0.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MovieImage(
                modifier = Modifier
                    .size(70.dp),
                imageUrl = item.image ?: PLACEHOLDER_IMAGE_URL
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        start = 12.dp,
                        end = 12.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6.copy(color = Color(0xFF444444))
                )

            }
        }
    }
}

val item =  MovieItemUiModel(
    "https://cdn.ebaumsworld.com/mediaFiles/picture/883100/86519706.jpg",
    title = "2021 John Watts SpiderMan"
)

@ExperimentalAnimationApi
@Preview(showBackground = true, backgroundColor = 0xffffff)
@Composable
fun MovieItemPreview() {
    MaterialTheme {
        MovieItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            item = item
        )
    }
}

