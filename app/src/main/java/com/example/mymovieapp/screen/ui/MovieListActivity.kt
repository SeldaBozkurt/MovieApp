package com.example.mymovieapp.screen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
class MovieListActivity : AppCompatActivity() {

    private val viewModel by viewModels<MovieListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MovieListScreen(viewModel)
            }
        }
    }
}