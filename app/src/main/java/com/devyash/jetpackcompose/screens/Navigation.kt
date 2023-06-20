package com.devyash.jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devyash.jetpackcompose.SCREEN


@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SCREEN.MainScreen.route) {
        composable(route = SCREEN.MainScreen.route) {
            mainScreen(navController = navController)
        }
        composable(
            route = SCREEN.DetailScreen.route + "/{name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                defaultValue = "Yash"
                nullable = true
            })
        ) { entry ->
            entry.arguments?.getString("name")?.let { DetailScreen(name = it) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(value = text, onValueChange = { it ->
            text = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(SCREEN.DetailScreen.withArgs(text))
        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "To Detail Screen")
        }
    }
}

@Composable
fun DetailScreen(name: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello, $name")
    }
}