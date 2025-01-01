package com.example.damon.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.damon.NavigationBar
import com.example.damon.NavigationBarGraph

@Composable
fun MainScreen(navRootController: NavHostController, modifier: Modifier = Modifier) {
    val navItemController = rememberNavController()
    Scaffold(
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavigationBarGraph(
                navItemController = navItemController,
                navRootController = navRootController
            )
        }
        NavigationBar(navRootController,navItemController)
    }
}