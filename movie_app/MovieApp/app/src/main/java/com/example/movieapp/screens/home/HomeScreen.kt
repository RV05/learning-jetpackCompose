package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Navigation.MovieScreens
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar={
        TopAppBar(backgroundColor = Color.LightGray,
            elevation=5.dp) {
            Text(text = "Movies")
        }
    }) {
       MainContent(navController=navController)
    }
}


@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies(

)){
    Column(modifier= Modifier.padding(12.dp)) {
        LazyColumn{
            items(items=movieList){
                MovieRow(movie = it){ movie ->
                    navController.navigate(route=MovieScreens.DetailsScreen.name+"/$movie")
                }

            }
        }
    }
}
